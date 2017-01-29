package com.example.johnwu.mtlmural;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;


public class MuralActivity extends FragmentActivity {

//    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural);
        new DownloadImageTask((ImageView) findViewById(R.id.imageMural))
                .execute("http://s.orzzzz.com/news/a0/b7//552f49e59cedd.jpg");
        TextView muralDescription = (TextView) findViewById(R.id.muralDescription);
        muralDescription.setText("Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile phones, fixed devices (e.g., desktop computers) or portable devices (e.g., tablet computers or smartphones). While text messages are usually sent over a phone network, due to the convergence between the telecommunication and broadcasting industries in the 2000s, text messages may also be sent via a cable network or Local Area Network. The term originally referred to messages sent using the Short Message Service (SMS). It has grown beyond alphanumeric text to include multimedia messages (known as MMS) containing digital images, videos, and sound content, as well as ideograms known as emoji (happy faces and other icons).\n" +
                "\n" +
                "As of 2017, text messages are used by youth and adults for personal, family and social purposes and in business, government and non-governmental organizations for communication between colleagues. As with emailing, in the 2010s, the sending of short informal messages has become an accepted part of many cultures. This makes texting a quick and easy way to communicate with friends and colleagues, including in contexts where a phone call would be impolite or inappropriate (e.g., calling very late at night or when one knows the other person is busy with family or work activities). Like e-mail and voice mail, and unlike landline or mobile phone calls (in which the caller hopes to speak directly with the recipient), texting does not require the caller and recipient to both be free at the same moment; this permits communication even between busy individuals. Text messages can also be used to interact with automated systems, for example, to order products or services from e-commerce websites, or to participate in online contests. Advertisers and service providers use direct text marketing to send messages to mobile phone users about promotions, payment due dates, and other notifications instead of using postal mail, email, or voicemail.");
        muralDescription.setMovementMethod(new ScrollingMovementMethod());


    }


    //write a method to get all the data from the backend

}
