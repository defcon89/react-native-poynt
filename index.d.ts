export declare interface Payment {
  transaction_id: string;
  payment_method: string;
  raw_data: string;
}

declare class Poynt {
  // Print Image
  static print(filePath: string): Promise<boolean>;

  // Pay
  static pay(amount: number, currency: string): Promise<boolean>;

  // Events
  static onPaymentCompleted(callback?: (payment: Payment) => void): void;
  static onPaymentAuthorized(callback?: (result: boolean) => void): void;
  static onPaymentCanceled(callback?: (result: boolean) => void): void;
  static onPaymentFailed(callback?: (result: boolean) => void): void;
  static onPaymentRefunded(callback?: (result: boolean) => void): void;
  static onPaymentVoided(callback?: (result: boolean) => void): void;

  static onPrintDone(callback?: (result: boolean) => void): void;
}

export default Poynt;
