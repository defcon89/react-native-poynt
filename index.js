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
      if (enabled) PoyntSDK.init(undefined);
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

  print = (image, callback) => {
    this.printCallback = callback;
    PoyntSDK.print(image, undefined);
  };

  pay = (amount, currency, callback) => {
    this.paymentCallback = callback;
    PoyntSDK.pay(amount, currency);
  };

  isPoyntTerminal = async () => {
    return await PoyntSDK.isPoyntTerminal();
  };
}

export default new Poynt();
