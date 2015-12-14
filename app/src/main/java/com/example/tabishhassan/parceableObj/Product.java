package com.example.tabishhassan.parceableObj;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tabishhassan on 6/23/15.
 */
public class Product implements Parcelable {

    private int product_id;
    private String product_name;
    private long product_prize;
    private String Descricption;

   public Product(int product_id, String product_name, long Product_prize, String Descricption){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_prize = Product_prize;
        this.Descricption = Descricption;
    }

    public int getProduct_id() {
        return product_id;
    }

    public long getProduct_prize() {
        return product_prize;
    }

    public String getDescricption() {
        return Descricption;
    }

    public String getProduct_name() {
        return product_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(product_id);
        dest.writeString(product_name);
        dest.writeLong(product_prize);
        dest.writeString(Descricption);
    }

    public Product(Parcel dest){
        product_id = dest.readInt();
        product_name = dest.readString();
        product_prize = dest.readLong();
        Descricption = dest.readString();
    }

    public static final  Creator<Product> CREATOR =  new Creator<Product>(){
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
