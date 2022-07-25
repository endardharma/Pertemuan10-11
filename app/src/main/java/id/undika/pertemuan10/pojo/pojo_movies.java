package id.undika.pertemuan10.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class pojo_movies implements Parcelable {
    //parcelable: kls interface myg mengirimkan data berupa object ke act 1 ke act lainnya
    // deklarasi variabel dari data movie
    private String title,realease_date,desc,review;
    private int poster;

    //constractor

    public pojo_movies() {
    }

    //getter n setter (alt+insert)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealease_date() {
        return realease_date;
    }

    public void setRealease_date(String realease_date) {
        this.realease_date = realease_date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    //const utk baca data
    public pojo_movies(Parcel parcel) {
        this.title = parcel.readString();
        this.realease_date = parcel.readString();
        this.desc = parcel.readString();
        this.review = parcel.readString();
        this.poster = parcel.readInt();
    }

    //object created
    public static final Creator<pojo_movies> CREATOR = new Creator<pojo_movies>() {
        @Override
        public pojo_movies createFromParcel(Parcel in) {
            return new pojo_movies(in);
        }

        @Override
        public pojo_movies[] newArray(int size) {
            return new pojo_movies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //add data yg mau dikirim
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(realease_date);
        parcel.writeString(desc);
        parcel.writeString(review);
        parcel.writeInt(poster);
    }
}
