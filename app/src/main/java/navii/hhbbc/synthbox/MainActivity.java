package navii.hhbbc.synthbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity";
    Button c2, cs2, d2, ds2, e2, f2, fs2, g2, gs2, a2, as2, b2;
    Button c3, cs3, d3, ds3, e3, f3, fs3, g3, gs3, a3, as3, b3, c4;
    private MediaPlayer mediaPlayer;
    private Map<Button, String> buttonNotes = new HashMap<>();
    private List<Button> allButtons = new ArrayList<>();

    //My interstitial ad unit: ca-app-pub-8590812801371878/8427151636

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BANNER AD
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, initializationStatus -> {});

        // Find the AdView and load an ad.
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //INTERSTITIAL AD
        MobileAds.initialize(this, initializationStatus -> prepareAd());
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (mInterstitialAd != null) {
//                            mInterstitialAd.show(MainActivity.this);
//                        } else {
//                            Log.d("TAG", "Interstitial not loaded");
//                            prepareAd();
//                        }
//                    }
//                });
//            }
//        }, 10, 10, TimeUnit.SECONDS);

        findViewById(R.id.key_c3_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });

        // Initialize buttons
        c2 = findViewById(R.id.key_c2);
        cs2 = findViewById(R.id.key_cs2);
        d2 = findViewById(R.id.key_d2);
        ds2 = findViewById(R.id.key_ds2);
        e2 = findViewById(R.id.key_e2);
        f2 = findViewById(R.id.key_f2);
        fs2 = findViewById(R.id.key_fs2);
        g2 = findViewById(R.id.key_g2);
        gs2 = findViewById(R.id.key_gs2);
        a2 = findViewById(R.id.key_a2);
        as2 = findViewById(R.id.key_as2);
        b2 = findViewById(R.id.key_b2);
        c3 = findViewById(R.id.key_c3);
        cs3 = findViewById(R.id.key_cs3);
        d3 = findViewById(R.id.key_d3);
        ds3 = findViewById(R.id.key_ds3);
        e3 = findViewById(R.id.key_e3);
        f3 = findViewById(R.id.key_f3);
        fs3 = findViewById(R.id.key_fs3);
        g3 = findViewById(R.id.key_g3);
        gs3 = findViewById(R.id.key_gs3);
        a3 = findViewById(R.id.key_a3);
        as3 = findViewById(R.id.key_as3);
        b3 = findViewById(R.id.key_b3);
        c4 = findViewById(R.id.key_c4);

        allButtons.add(c2);
        allButtons.add(cs2);
        allButtons.add(d2);
        allButtons.add(ds2);
        allButtons.add(e2);
        allButtons.add(f2);
        allButtons.add(fs2);
        allButtons.add(g2);
        allButtons.add(gs2);
        allButtons.add(a2);
        allButtons.add(as2);
        allButtons.add(b2);
        allButtons.add(c3);
        allButtons.add(cs3);
        allButtons.add(d3);
        allButtons.add(ds3);
        allButtons.add(e3);
        allButtons.add(f3);
        allButtons.add(fs3);
        allButtons.add(g3);
        allButtons.add(gs3);
        allButtons.add(a3);
        allButtons.add(as3);
        allButtons.add(b3);
        allButtons.add(c4);

        // Map buttons to their note names
        buttonNotes.put(c2, "C2");
        buttonNotes.put(cs2, "C#2");
        buttonNotes.put(d2, "D2");
        buttonNotes.put(ds2, "D#2");
        buttonNotes.put(e2, "E2");
        buttonNotes.put(f2, "F2");
        buttonNotes.put(fs2, "F#2");
        buttonNotes.put(g2, "G2");
        buttonNotes.put(gs2, "G#2");
        buttonNotes.put(a2, "A2");
        buttonNotes.put(as2, "A#2");
        buttonNotes.put(b2, "B2");
        buttonNotes.put(c3, "C3");
        buttonNotes.put(cs3, "C#3");
        buttonNotes.put(d3, "D3");
        buttonNotes.put(ds3, "D#3");
        buttonNotes.put(e3, "E3");
        buttonNotes.put(f3, "F3");
        buttonNotes.put(fs3, "F#3");
        buttonNotes.put(g3, "G3");
        buttonNotes.put(gs3, "G#3");
        buttonNotes.put(a3, "A3");
        buttonNotes.put(as3, "A#3");
        buttonNotes.put(b3, "B3");
        buttonNotes.put(c4, "C4");

        setKeyListeners();
    }

    private void prepareAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Code to be executed when the interstitial ad is dismissed.
                                Log.d("TAG", "The ad was dismissed.");
                                mInterstitialAd = null;
                                prepareAd();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                // Code to be executed when the ad failed to be shown.
                                Log.d("TAG", "The ad failed to show.");
                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Code to be executed when the ad is shown.
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        // Code to be executed when an ad request fails.
                        Log.d("TAG", adError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }
    private void setKeyListeners() {
        setKeyListener(c2, R.raw.c2);
        setKeyListener(cs2, R.raw.cs2);
        setKeyListener(d2, R.raw.d2);
        setKeyListener(ds2, R.raw.ds2);
        setKeyListener(e2, R.raw.e2);
        setKeyListener(f2, R.raw.f2);
        setKeyListener(fs2, R.raw.fs2);
        setKeyListener(g2, R.raw.g2);
        setKeyListener(gs2, R.raw.gs2);
        setKeyListener(a2, R.raw.a2);
        setKeyListener(as2, R.raw.as2);
        setKeyListener(b2, R.raw.b2);
        setKeyListener(c3, R.raw.c3);
        setKeyListener(cs3, R.raw.cs3);
        setKeyListener(d3, R.raw.d3);
        setKeyListener(ds3, R.raw.ds3);
        setKeyListener(e3, R.raw.e3);
        setKeyListener(f3, R.raw.f3);
        setKeyListener(fs3, R.raw.fs3);
        setKeyListener(g3, R.raw.g3);
        setKeyListener(gs3, R.raw.gs3);
        setKeyListener(a3, R.raw.a3);
        setKeyListener(as3, R.raw.as3);
        setKeyListener(b3, R.raw.b3);
        setKeyListener(c4, R.raw.c4);
    }

    private void setKeyListener(Button key, int soundResource) {
        key.setOnClickListener(v -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.release();
//            }
            mediaPlayer = MediaPlayer.create(MainActivity.this, soundResource);
            mediaPlayer.setOnCompletionListener(mp -> mp.release());
            mediaPlayer.start();

            updateButtonColors(key);
        });
    }

    private void updateButtonColors(Button pressedKey) {
        resetButtonColors();
        String note = buttonNotes.get(pressedKey);
        if (note != null) {
            highlightChord(note);
        }
    }

    private void highlightChord(String rootNote) {
        List<String> majorChordNotes = getMajorChordNotes(rootNote);
        List<String> minorChordNotes = getMinorChordNotes(rootNote);
        List<String> augmentedChordNotes = getAugmentedChordNotes(rootNote);
        List<String> diminishedChordNotes = getDiminishedChordNotes(rootNote);

        for (Map.Entry<Button, String> entry : buttonNotes.entrySet()) {
            String note = entry.getValue();
            if (majorChordNotes.contains(note)) {
                entry.getKey().setBackgroundColor(Color.YELLOW);
            }
            if (minorChordNotes.contains(note) && !majorChordNotes.contains(note)) {
                entry.getKey().setBackgroundColor(0xFFD2B48C); // Light brown
            }
            if (augmentedChordNotes.contains(note) && !majorChordNotes.contains(note)) {
                entry.getKey().setBackgroundColor(0xFFD28C8C); // Light maroon
            }
            if (diminishedChordNotes.contains(note) && !majorChordNotes.contains(note)) {
                entry.getKey().setBackgroundColor(0xFF8C8CD2); // Light navy blue
            }
        }
    }

    private List<String> getMajorChordNotes(String rootNote) {
        return getChordNotes(rootNote, 4, 7); // Major chord: root, major third, perfect fifth
    }

    private List<String> getMinorChordNotes(String rootNote) {
        return getChordNotes(rootNote, 3, 7); // Minor chord: root, minor third, perfect fifth
    }

    private List<String> getAugmentedChordNotes(String rootNote) {
        return getChordNotes(rootNote, 0, 8); // Augmented chord: root, major third, augmented fifth
    }

    private List<String> getDiminishedChordNotes(String rootNote) {
        return getChordNotes(rootNote, 0, 6); // Diminished chord: root, minor third, diminished fifth
    }

    private List<String> getChordNotes(String rootNote, int thirdInterval, int fifthInterval) {
        List<String> notes = new ArrayList<>();
        String[] noteOrder = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

        String root = rootNote.substring(0, rootNote.length() - 1);
        int octave = Integer.parseInt(rootNote.substring(rootNote.length() - 1));
        int rootIndex = -1;

        for (int i = 0; i < noteOrder.length; i++) {
            if (noteOrder[i].equals(root)) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1) return notes;

        for (int i = -1; i <= 1; i++) {
            int currentOctave = octave + i;
            if (currentOctave >= 2 && currentOctave <= 4) {
                notes.add(noteOrder[(rootIndex + 0) % 12] + currentOctave);
                notes.add(noteOrder[(rootIndex + thirdInterval) % 12] + ((rootIndex + thirdInterval) / 12 + currentOctave));
                notes.add(noteOrder[(rootIndex + fifthInterval) % 12] + ((rootIndex + fifthInterval) / 12 + currentOctave));
            }
        }

        return notes;
    }

    private void resetButtonColors() {
        for (Button button : allButtons) {
            String note = buttonNotes.get(button);
            if (note != null && note.contains("#")) {
                button.setBackgroundColor(Color.BLACK);
            } else {
                button.setBackgroundColor(Color.WHITE);
            }
        }
    }

    @Override
    protected void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
