import { NativeModules, NativeEventEmitter, Platform } from "react-native";

const PoyntSDK = NativeModules.Poynt;
const EventEmitter = new NativeEventEmitter(PoyntSDK);

class Poynt {
  paymentCallback = undefined;
  printCallback = undefined;

  constructor() {
    EventEmitter.addListener("paymentCompleted", this._onPaymentCompleted);
    EventEmitter.addListener("paymentAuthorized", this._onPaymentAuthorized);
    EventEmitter.addListener("paymentCanceled", this._onPaymentCanceled);
    EventEmitter.addListener("paymentFailed", this._onPaymentFailed);
    EventEmitter.addListener("paymentRefunded", this._onPaymentRefunded);
    EventEmitter.addListener("paymentVoided", this._onPaymentVoided);
    EventEmitter.addListener("printDone", this._onPrintDone);

    this.isPoyntTerminal().then((enabled) => {
      if (enabled) PoyntSDK.init(() => {});
    });
  }

  _onPaymentCompleted = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  _onPaymentAuthorized = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  _onPaymentCanceled = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(false, callback);
  };

  _onPaymentFailed = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(false, callback);
  };

  _onPaymentRefunded = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  _onPaymentVoided = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  _onPrintDone = (callback) => {
    if (!this.printCallback) return;
    this.printCallback(callback);
  };

  init = (callback) => {
    PoyntSDK.init(callback);
  };

  refreshPrinters = () => {
    PoyntSDK.refreshPrinters();
  };

  print = (image, callback) => {
    this.printCallback = callback;
    PoyntSDK.print(image, callback);
  };

  printVoucher = (domain_text,user_text,booking_string,voucher_text,hidePrice,callback) => {
    this.printCallback = callback;
    PoyntSDK.printVoucher(domain_text,user_text,booking_string,voucher_text,hidePrice,callback);
  };

  printSingleVoucherFromBooking = (domain_text,user_text,booking_string,ticket_text,voucher_text,hidePrice,callback) => {
    this.printCallback = callback;
    PoyntSDK.printSingleVoucherFromBooking(domain_text,user_text,booking_string,ticket_text,voucher_text,hidePrice,callback);
  }

  printSingleVoucher = (domain_text,user_text,tripBooking_text,pkg_text,booking_preview_text,tripBookingParticipant_text,ticket_text,voucher_text,callback) => {
    this.printCallback = callback;
    PoyntSDK.printSingleVoucher(domain_text,user_text,tripBooking_text,pkg_text,booking_preview_text,tripBookingParticipant_text,ticket_text,voucher_text,callback);
  };
  

  printSalesSummary = (tripBookingsReport_text, user_text, callback) => {
    this.printCallback = callback;
    PoyntSDK.printSalesSummary(tripBookingsReport_text, user_text, callback);
  }

  pay = (amount, currency, callback) => {
    this.paymentCallback = callback;
    PoyntSDK.pay(amount, currency);
  };

  isPoyntTerminal = async () => {
    return await PoyntSDK.isPoyntTerminal();
  };
}

export default new Poynt();
