package com.reactlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Nullable;

import co.poynt.os.model.AccessoryProvider;
import co.poynt.os.model.Intents;
import co.poynt.os.model.Payment;
import co.poynt.os.model.PaymentStatus;
import co.poynt.os.model.PrinterStatus;
import co.poynt.os.services.v1.IPoyntPrinterService;


import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

public class PoyntModule extends ReactContextBaseJavaModule implements LifecycleEventListener, ActivityEventListener {
  private final int COLLECT_PAYMENT_REQUEST = 101;
  private final ReactApplicationContext reactContext;
  private PrinterServiceHelper printerServiceHelper;

  public PoyntModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.reactContext.addLifecycleEventListener(this);
    this.reactContext.addActivityEventListener(this);
  }

  @Override
  public String getName() {
    return "Poynt";
  }

  @ReactMethod
  public void init(final Callback callback) {
    this.printerServiceHelper = new PrinterServiceHelper(this.reactContext, new PrinterServiceHelper.PrinterCallback() {
      @Override
      public void onPrinterResponse(PrinterStatus status) {
        callback.invoke(true);
      }

      @Override
      public void onPrinterReconnect(IBinder binder) {
        callback.invoke(true);
      }

      @Override
      public void logMessage(String s) {

      }
    });
    printerServiceHelper.bindAccessoryManager();
  }

  /**
   * @return true is the app is running on a Poynt terminal and has a card reader
   */
  @ReactMethod
  private void isPoyntTerminal(Promise promise) {
    promise.resolve("POYNT".equals(Build.MANUFACTURER));
  }

  @ReactMethod
  private void printVoucher(String domain_text, String user_text, String booking_string, boolean hidePrice, Callback callback){
    if (printerServiceHelper == null) {
      showToast("MAKE INIT BEFORE PRINT");
      callback.invoke(false);
      return;
    }

    Bitmap ticket = PrinterHelper.createVoucher(this.reactContext, domain_text, user_text, booking_string, hidePrice);
    printBitmap(ticket, callback);
  }

  @ReactMethod
  private void printSingleVoucher(String domain_text, String user_text, String tripBooking_text, String pkg_text, String booking_preview_text, String tripBookingParticipant_text, String ticket_text, Callback callback){
    if (printerServiceHelper == null) {
      showToast("MAKE INIT BEFORE PRINT");
      callback.invoke(false);
      return;
    }

    Bitmap ticket = PrinterHelper.createVoucherSingle(this.reactContext, domain_text, user_text, tripBooking_text, pkg_text, booking_preview_text, tripBookingParticipant_text, ticket_text);
    printBitmap(ticket, callback);
  }

  @ReactMethod
  private void printSalesSummary(String tripBookingsReport_text, Callback callback){
    if (printerServiceHelper == null) {
      showToast("MAKE INIT BEFORE PRINT");
      callback.invoke(false);
      return;
    }

    Bitmap summary = PrinterHelper.createSalesSummaryTicket(this.reactContext, tripBookingsReport_text);
    printBitmap(summary, callback);
  }

  @ReactMethod
  public void print(String filePath, Callback callback) {
    if (printerServiceHelper == null) {
      showToast("MAKE INIT BEFORE PRINT");
      callback.invoke(false);
      return;
    }

    Bitmap bmp = BitmapFactory.decodeFile(filePath);
    printBitmap(bmp, callback);
  }

  @ReactMethod
  public void pay(int amount, String currencyCode) {
    Activity currentActivity = getCurrentActivity();

    Payment payment = new Payment();
    payment.setAmount(amount * 100);
    payment.setCurrency(currencyCode);

    Intent collectPaymentIntent = new Intent(Intents.ACTION_COLLECT_PAYMENT);
    collectPaymentIntent.putExtra(Intents.INTENT_EXTRAS_PAYMENT, payment);
    currentActivity.startActivityForResult(collectPaymentIntent, COLLECT_PAYMENT_REQUEST);
  }

  @Override
  public void onHostResume() {
    if (this.printerServiceHelper == null) return;
    this.printerServiceHelper.bindAccessoryManager();
  }

  @Override
  public void onHostPause() {

  }

  @Override
  public void onHostDestroy() {
    if (this.printerServiceHelper == null) return;
    this.printerServiceHelper.unBindServices();
    this.printerServiceHelper.unBindPrinters();
  }


  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Gson gson = new Gson();

    // Check which request we're responding to
    if (requestCode == COLLECT_PAYMENT_REQUEST) {
      // Make sure the request was successful
      if (resultCode == Activity.RESULT_OK) {
        if (data != null) {
          Payment payment = data.getParcelableExtra(Intents.INTENT_EXTRAS_PAYMENT);
          Log.d("POYNT", "Received onPaymentAction from PaymentFragment w/ Status(" + payment.getStatus() + ")");
          if (payment.getStatus().equals(PaymentStatus.COMPLETED)) {
            WritableMap params = Arguments.createMap();
            params.putString("transaction_id", payment.getTransactionId());
            params.putString("payment_method", payment.getActionLabel());
            params.putString("raw_data", gson.toJson(payment));
            sendEvent("paymentCompleted", params);
          } else if (payment.getStatus().equals(PaymentStatus.AUTHORIZED)) {
            sendEvent("paymentAuthorized", true);
          } else if (payment.getStatus().equals(PaymentStatus.CANCELED)) {
            sendEvent("paymentCanceled", true);
          } else if (payment.getStatus().equals(PaymentStatus.FAILED)) {
            sendEvent("paymentFailed", true);
          } else if (payment.getStatus().equals(PaymentStatus.REFUNDED)) {
            sendEvent("paymentRefunded", true);
          } else if (payment.getStatus().equals(PaymentStatus.VOIDED)) {
            sendEvent("paymentVoided", true);
          }
        }
      } else if (resultCode == Activity.RESULT_CANCELED) {
        sendEvent("paymentCanceled", true);
      }
    }
  }

  //////////////////////////////////
  // LOCAL PRIVATE METHODS
  //////////////////////////////////
  // print bitmap
  private void printBitmap(Bitmap bmp, Callback callback){
    if (bmp == null) {
      callback.invoke(false);
      return;
    }

    Bundle data = new Bundle();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
    byte[] byteArray = stream.toByteArray();
    bmp.recycle();

    HashMap<AccessoryProvider, IBinder> printers = printerServiceHelper.getPrinters();
    for (AccessoryProvider printer : printers.keySet()) {
      if (printer.isConnected()) {
        final IPoyntPrinterService printerService = IPoyntPrinterService.Stub.asInterface(printers.get(printer));
        showToast("PRINTER CONNECTED");
        if (printerService != null) {
          Log.e("PRINTER", "SERVICE CONNECTED");
          if (byteArray == null) return;
          Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
          showToast("VOUCHER CREATED");
          Log.e("PRINTER", "BITMAP CREATED");
          try {
            printerService.printJob(UUID.randomUUID().toString(), bitmap, printerServiceHelper.printerServiceListener);
            showToast("PRINTING");
            sendEvent("printDone", true);
            if (callback != null) callback.invoke(true);
          } catch (RemoteException e) {
            e.printStackTrace();
          }
        } else {
          if (callback != null) callback.invoke(false);
          showToast("SERVICE NOT CONNECTED");
        }
      } else {
        Log.e("PRINTER", "NOT CONNECTED");
        if (callback != null) callback.invoke(false);
        showToast("PRINTER NOT CONNECTED");
        printerServiceHelper.reconnectPrinter(printer);
      }
    }
  }

  // sends an event to javascript Realm (Object data)
  private void sendEvent(String eventName,
                         @Nullable WritableMap params) {
    getReactApplicationContext()
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, params);
  }

  // sends an event to javascript Realm (String data)
  private void sendEvent(String eventName,
                         @Nullable String s) {
    getReactApplicationContext()
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, s);
  }

  // sends an event to javascript Realm (String data)
  private void sendEvent(String eventName,
                         @Nullable Boolean b) {
    getReactApplicationContext()
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, b);
  }

  private void showToast(String msg) {
    final String strMsg = msg;
    runOnUiThread(new Runnable() {
      public void run() {
        Toast.makeText(getReactApplicationContext(), strMsg, Toast.LENGTH_SHORT).show();
      }
    });
  }


}
