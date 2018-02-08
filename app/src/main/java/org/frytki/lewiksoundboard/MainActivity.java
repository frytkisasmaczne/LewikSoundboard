package org.frytki.lewiksoundboard;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    public MainActivity(){
        if(wersja >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build();
            soundPool = new SoundPool.Builder().setAudioAttributes(audioAttrib).setMaxStreams(30).build();
        }
        else{
            soundPool = new SoundPool(30, AudioManager.STREAM_MUSIC, 0);
        }
    }

    //<editor-fold desc="deklaracje">

    SoundPool soundPool;
    int wersja = Build.VERSION.SDK_INT;
    int i[] = new int[41];
    int p[] = new int[41];
    String mtag;
    private AdView mAdView;
    boolean alreadyShownToasts = false;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-5610435366961001~8059398557");
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
                                  @Override
                                  public void onAdLoaded() {
                                      if(alreadyShownToasts == false) {
                                          Toast.makeText(MainActivity.this, "Jeśli klikniesz w reklamę to dostanę jakiś ułamek grosza na frytki xD", Toast.LENGTH_LONG).show();
                                          Toast.makeText(MainActivity.this, "100% scam no legit", Toast.LENGTH_SHORT).show();
                                          alreadyShownToasts = true;
                                      }
                                      else{
                                          Toast.makeText(MainActivity.this, "Klikanie w reklamy jest spoko", Toast.LENGTH_SHORT).show();
                                      }
                                  }
                              });

        //<editor-fold desc="soundPool.load();">
        i[0] = soundPool.load(this, R.raw.auschwitz, 1);
        i[1] = soundPool.load(this, R.raw.bog_zaplac, 1);
        i[2] = soundPool.load(this, R.raw.dobranoc, 1);
        i[3] = soundPool.load(this, R.raw.dobry_wieczor, 1);
        i[4] = soundPool.load(this, R.raw.dowiesz_sie_w_swoim_czasie, 1);
        i[5] = soundPool.load(this, R.raw.dzwiek_wieloryba, 1);
        i[6] = soundPool.load(this, R.raw.frytki_lepsze, 1);
        i[7] = soundPool.load(this, R.raw.grzybow_sto, 1);
        i[8] = soundPool.load(this, R.raw.jaa, 1);
        i[9] = soundPool.load(this, R.raw.jak_za_darmo, 1);
        i[10] = soundPool.load(this, R.raw.kici_kici, 1);
        i[11] = soundPool.load(this, R.raw.kiedy, 1);
        i[12] = soundPool.load(this, R.raw.kujon, 1);
        i[13] = soundPool.load(this, R.raw.kultury_bys_sie_nauczyl, 1);
        i[14] = soundPool.load(this, R.raw.lepiej_nie, 1);
        i[15] = soundPool.load(this, R.raw.mama_cie_nie_kocha, 1);
        i[16] = soundPool.load(this, R.raw.masz_towar, 1);
        i[17] = soundPool.load(this, R.raw.mlodziencze, 1);
        i[18] = soundPool.load(this, R.raw.moze_jutro, 1);
        i[19] = soundPool.load(this, R.raw.naucz_sie_kultury, 1);
        i[20] = soundPool.load(this, R.raw.nie_bedziemy_tesknic, 1);
        i[21] = soundPool.load(this, R.raw.nie_obchodzi_mnie_to, 1);
        i[22] = soundPool.load(this, R.raw.nie_zgub_sie, 1);
        i[23] = soundPool.load(this, R.raw.niechcacy, 1);
        i[24] = soundPool.load(this, R.raw.nikt_cie_nie_kocha, 1);
        i[25] = soundPool.load(this, R.raw.o_ty_murzynie_bialy, 1);
        i[26] = soundPool.load(this, R.raw.oczywiscie, 1);
        i[27] = soundPool.load(this, R.raw.odbieraj_telefony_cwelu, 1);
        i[28] = soundPool.load(this, R.raw.policjant, 1);
        i[29] = soundPool.load(this, R.raw.smierc, 1);
        i[30] = soundPool.load(this, R.raw.spokojnie, 1);
        i[31] = soundPool.load(this, R.raw.szczesc_boze, 1);
        i[32] = soundPool.load(this, R.raw.to_masz_problem, 1);
        i[33] = soundPool.load(this, R.raw.twoja_stara_ma_malego, 1);
        i[34] = soundPool.load(this, R.raw.witaj, 1);
        i[35] = soundPool.load(this, R.raw.z_bogiem, 1);
        i[36] = soundPool.load(this, R.raw.z_twojej_mamy, 1);
        i[37] = soundPool.load(this, R.raw.za_mlody_jestes, 1);
        i[38] = soundPool.load(this, R.raw.zabij_sie, 1);
        i[39] = soundPool.load(this, R.raw.zdrajco_ojczyzny, 1);
        i[40] = soundPool.load(this, R.raw.zlodziej, 1);
        //</editor-fold>

    }

    void onClick (View v){
        mtag = (String) v.getTag();
        p[Integer.parseInt(mtag)] = soundPool.play(i[Integer.parseInt(mtag)],1,1,0,0,1);
    }

}
