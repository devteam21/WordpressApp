package com.cinehitz.cinehitzapp.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;

import com.cinehitz.cinehitzapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Tools extends AppCompatActivity {





    public static void aboutAction(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.about));
        builder.setMessage(Html.fromHtml(activity.getString(R.string.about_text)));
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public static void privacyAction(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Privacy Policy");
        builder.setMessage(Html.fromHtml(activity.getString(R.string.privacy_text)));
        builder.setPositiveButton("Accept", null);
        builder.show();
    }


    public static void rateAction(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }
    }

    public static void moreAction(Activity activity) {
        Uri uri = Uri.parse("market://developer?id=Tamil+Entertainment+World&hl=en");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Tamil+Entertainment+World&hl=en")));
        }

    }

    public static void shareAction(Activity activity) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        String shareBody = "CineHitz is  latest cinema news and movie review app.\nDownload App now\n" + "https://play.google.com/store/apps/details?id=" + activity.getApplicationContext().getPackageName();
        share.putExtra(Intent.EXTRA_TEXT, shareBody);
        activity.startActivity(Intent.createChooser(share, "share using"));
    }

    @NonNull
    public static void sharePost(Activity activity, String title, String postUrl, String content) {

//        Uri imageUri = Uri.parse(imageUrl);
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
//        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
//        shareIntent.setType("image/*");
//        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        activity.startActivity(Intent.createChooser(shareIntent, "send"));

        // string to share
        StringBuilder sb = new StringBuilder();
        sb.append(title + "\n");
        sb.append("Source Link : " + postUrl + "\n");
        sb.append(content + "\n");
        sb.append("Download app from playstore: " + "https://play.google.com/store/apps/details?id=" + activity.getApplicationContext().getPackageName());

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, activity.getString(R.string.app_name));
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        activity.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }

    public static String getDurationTimeStamp(String date) {
        date = date.replace("T", " ");
        String timeDifference = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startDate = null;
        try {
            startDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = new Date();
        long duration = endDate.getTime() - startDate.getTime();
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        if (diffInDays > 365) {
            int year = (int) (diffInDays / 365);
            timeDifference = year + " years ago";
            return timeDifference;
        } else if (diffInDays > 1 && diffInDays<=30) {
            timeDifference = diffInDays + " days ago";
            return timeDifference;
        }  else if (diffInDays>=31) {
            int month = (int) (diffInDays/30);
            timeDifference = month + " months ago";
            return timeDifference;
        }else if (diffInHours > 1 && diffInHours<=23) {
            timeDifference = diffInHours + " hours ago";
            return timeDifference;
        } else if(diffInHours>=24){
            int day = (int) (diffInHours/24);
            timeDifference = day+" days ago";
            return timeDifference;
        }else if (diffInMinutes > 1 && diffInMinutes<59) {
            timeDifference = diffInMinutes + " minutes ago";
            return timeDifference;
        }else if (diffInMinutes >=60) {
            int hour = (int) (diffInMinutes/60);
            timeDifference = hour + " hour ago";
            return timeDifference;
        }else if (diffInSeconds > 1) {
            timeDifference = diffInSeconds + " seconds ago";
            return timeDifference;
        }

        return timeDifference;

    }

}
