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

  // Print Voucher
  static printVoucher(
    domain_text: string,
    user_text: string,
    booking_string: string,
    voucher_text: string,
    hidePrice: boolean,
    callback?: (success: boolean) => void
  ): Promise<boolean>;

  // Print Single Voucher
  static printSingleVoucherFromBooking(
    domain_text: string,
    user_text: string,
    booking_string: string,
    ticket_text: string,
    voucher_text: string,
    hidePrice: boolean,
    callback?: (success: boolean) => void
  ): Promise<boolean>;

  // Print Single Voucher
  static printSingleVoucher(
    domain_text: string,
    user_text: string,
    tripBooking_text: string,
    pkg_text: string,
    booking_preview_text: string,
    tripBookingParticipant_text: string,
    ticket_text: string,
    voucher_text: string,
    callback?: (success: boolean) => void
  ): Promise<boolean>;

  //Print Sales Summary
  static printSalesSummary(
    tripBookingsReport_text: string,
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

  // refresh Printers
  static refreshPrinters(): Promise<boolean>;
}

export default Poynt;
