package com.techybazaar.wordpressapp.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;

import com.techybazaar.wordpressapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Tools extends AppCompatActivity {

    private Activity activity;
    public static String date="hh";

    public Tools(Activity activity) {
        this.activity = activity;
    }

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
    public static void moreAction(Activity activity){
        Uri uri = Uri.parse("market://developer?id=Tamil+Entertainment+World&hl=en" );
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
        String shareBody = "CineHitz is  latest cinema news and movie review app.\nDownload App now\n"+ "https://play.google.com/store/apps/details?id=" + activity.getApplicationContext().getPackageName();
        share.putExtra(Intent.EXTRA_TEXT, shareBody);
        activity.startActivity(Intent.createChooser(share, "share using"));
    }

    @NonNull
    public static  void sharePost(Activity activity,  String title, String postUrl , String content){

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
        sb.append(title+"\n");
        sb.append("Source Link : " + postUrl + "\n");
        sb.append(content + "\n");
        sb.append("Download app from playstore: " + "https://play.google.com/store/apps/details?id=" + activity.getApplicationContext().getPackageName());

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, activity.getString(R.string.app_name));
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        activity.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }

    public static String getFormatedDate(String date_str) {
        if (date_str != null && !date_str.trim().equals("")) {
            SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm");
            try {
                String newStr = newFormat.format(oldFormat.parse(date_str));
                return newStr;
            } catch (ParseException e) {
                return "";
            }
        } else {
            return "";
        }
    }

    public static void getFormatedDateSimple(String date_str) {
        if (date_str != null && !date_str.trim().equals("")) {
            SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");
            try {
                String newStr = newFormat.format(oldFormat.parse(date_str));
                date = newStr;

            } catch (ParseException e) {

            }
        }
    }
}
