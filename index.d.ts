export declare interface Payment {
  transaction_id: string;
  payment_method: string;
  raw_data: string;
}

declare class Poynt {
  // Print Image
  static print(
    filePath: string,
    callback?: (success: boolean) => void
  ): Promise<boolean>;

  // Pay
  static pay(
    amount: number,
    currency: string,
    callback?: (success: boolean, result: any) => void
  ): Promise<boolean>;

  // isPoyntTerminal
  static async isPoyntTerminal(): Promise<boolean>;
}

export default Poynt;
