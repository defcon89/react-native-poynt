import { NativeModules, NativeEventEmitter, Platform } from "react-native";

const PoyntSDK = NativeModules.Poynt;
const EventEmitter = new NativeEventEmitter(PoyntSDK);

class Poynt {
  paymentCallback = undefined;
  printCallback = undefined;

  constructor() {
    EventEmitter.addListener("paymentCompleted", this.onPaymentCompleted);
    EventEmitter.addListener("paymentAuthorized", this.onPaymentAuthorized);
    EventEmitter.addListener("paymentCanceled", this.onPaymentCanceled);
    EventEmitter.addListener("paymentFailed", this.onPaymentFailed);
    EventEmitter.addListener("paymentRefunded", this.onPaymentRefunded);
    EventEmitter.addListener("paymentVoided", this.onPaymentVoided);
    EventEmitter.addListener("printDone", this.onPrintDone);
    PoyntSDK.init(undefined);
  }

  onPaymentCompleted = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  onPaymentAuthorized = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  onPaymentCanceled = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(false, callback);
  };

  onPaymentFailed = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(false, callback);
  };

  onPaymentRefunded = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  onPaymentVoided = (callback) => {
    if (!this.paymentCallback) return;
    this.paymentCallback(true, callback);
  };

  onPrintDone = (callback) => {
    if (!this.printCallback) return;
    this.printCallback(callback);
  };

  init = (callback) => {
    PoyntSDK.init(callback);
  };

  print = (image, callback) => {
    this.printCallback = callback;
    PoyntSDK.print(image, undefined);
  };

  pay = (amount, currency, callback) => {
    this.paymentCallback = callback;
    PoyntSDK.pay(amount, currency);
  };
}

export default new Poynt();
