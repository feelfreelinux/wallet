// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ./paymentrequest.proto
package org.bitcoin.protocols.payments;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.BYTES;
import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REPEATED;

public final class Payment extends Message {
  private static final long serialVersionUID = 0L;

  public static final ByteString DEFAULT_MERCHANT_DATA = ByteString.EMPTY;
  public static final List<ByteString> DEFAULT_TRANSACTIONS = Collections.emptyList();
  public static final List<Output> DEFAULT_REFUND_TO = Collections.emptyList();
  public static final String DEFAULT_MEMO = "";

  @ProtoField(tag = 1, type = BYTES)
  public final ByteString merchant_data;

  /**
   * From PaymentDetails.merchant_data
   */
  @ProtoField(tag = 2, type = BYTES, label = REPEATED)
  public final List<ByteString> transactions;

  /**
   * Signed transactions that satisfy PaymentDetails.outputs
   */
  @ProtoField(tag = 3, label = REPEATED, messageType = Output.class)
  public final List<Output> refund_to;

  /**
   * Where to send refunds, if a refund is necessary
   */
  @ProtoField(tag = 4, type = STRING)
  public final String memo;

  public Payment(ByteString merchant_data, List<ByteString> transactions, List<Output> refund_to, String memo) {
    this.merchant_data = merchant_data;
    this.transactions = immutableCopyOf(transactions);
    this.refund_to = immutableCopyOf(refund_to);
    this.memo = memo;
  }

  private Payment(Builder builder) {
    this(builder.merchant_data, builder.transactions, builder.refund_to, builder.memo);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Payment)) return false;
    Payment o = (Payment) other;
    return equals(merchant_data, o.merchant_data)
        && equals(transactions, o.transactions)
        && equals(refund_to, o.refund_to)
        && equals(memo, o.memo);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = merchant_data != null ? merchant_data.hashCode() : 0;
      result = result * 37 + (transactions != null ? transactions.hashCode() : 1);
      result = result * 37 + (refund_to != null ? refund_to.hashCode() : 1);
      result = result * 37 + (memo != null ? memo.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends Message.Builder<Payment> {

    public ByteString merchant_data;
    public List<ByteString> transactions;
    public List<Output> refund_to;
    public String memo;

    public Builder() {
    }

    public Builder(Payment message) {
      super(message);
      if (message == null) return;
      this.merchant_data = message.merchant_data;
      this.transactions = copyOf(message.transactions);
      this.refund_to = copyOf(message.refund_to);
      this.memo = message.memo;
    }

    public Builder merchant_data(ByteString merchant_data) {
      this.merchant_data = merchant_data;
      return this;
    }

    /**
     * From PaymentDetails.merchant_data
     */
    public Builder transactions(List<ByteString> transactions) {
      this.transactions = checkForNulls(transactions);
      return this;
    }

    /**
     * Signed transactions that satisfy PaymentDetails.outputs
     */
    public Builder refund_to(List<Output> refund_to) {
      this.refund_to = checkForNulls(refund_to);
      return this;
    }

    /**
     * Where to send refunds, if a refund is necessary
     */
    public Builder memo(String memo) {
      this.memo = memo;
      return this;
    }

    @Override
    public Payment build() {
      return new Payment(this);
    }
  }
}