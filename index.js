import { NativeModules, DeviceEventEmitter, Platform } from "react-native";

const { Poynt } = NativeModules;

let paymentCompleted;
let paymentAuthorized;
let paymentCanceled;
let paymentFailed;
let paymentRefunded;
let paymentVoided;
let printDone;

const onPaymentCompleted = (callback) => {
  paymentCompleted = DeviceEventEmitter.addListener(
    "paymentCompleted",
    callback
  );
};

const onPaymentAuthorized = (callback) => {
  paymentAuthorized = DeviceEventEmitter.addListener(
    "paymentAuthorized",
    callback
  );
};

const onPaymentCanceled = (callback) => {
  paymentCanceled = DeviceEventEmitter.addListener("paymentCanceled", callback);
};

const onPaymentFailed = (callback) => {
  paymentFailed = DeviceEventEmitter.addListener("paymentFailed", callback);
};

const onPaymentRefunded = (callback) => {
  paymentRefunded = DeviceEventEmitter.addListener("paymentRefunded", callback);
};

const onPaymentVoided = (callback) => {
  paymentVoided = DeviceEventEmitter.addListener("paymentVoided", callback);
};

const onPrintDone = (callback) => {
  printDone = DeviceEventEmitter.addListener("printDone", callback);
};

const init = (callback) => {
  Poynt.init(callback);
};

const print = (image, callback) => {
  Poynt.print(image, callback);
};

const pay = (amount, currency, callback) => {
  Poynt.pay(amount, currency);
};

if (Platform.OS === "android") {
  Poynt.init();
}

export default {
  onPaymentCompleted,
  onPaymentAuthorized,
  onPaymentCanceled,
  onPaymentFailed,
  onPaymentRefunded,
  onPaymentVoided,
  onPrintDone,
  print,
  pay,
};

export default Poynt;
