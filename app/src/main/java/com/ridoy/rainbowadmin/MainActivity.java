package com.ridoy.rainbowadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.ridoy.rainbowadmin.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DatabaseReference reference;
    KProgressHUD hud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hud=KProgressHUD.create(MainActivity.this);
        hud.setDimAmount(0.5f);
        hud.show();
        reference = FirebaseDatabase.getInstance().getReference();

        binding.supportLink.setFocusableInTouchMode(false);
        binding.supportLink.setFocusable(false);
        binding.supportLink.requestFocus();
        binding.claimbalanceguide.setFocusableInTouchMode(false);
        binding.claimbalanceguide.setFocusable(false);
        binding.videotId.setFocusableInTouchMode(false);
        binding.videotId.setFocusable(false);
        binding.videoguideTXT.setFocusableInTouchMode(false);
        binding.videoguideTXT.setFocusable(false);
        binding.incomeguide.setFocusableInTouchMode(false);
        binding.incomeguide.setFocusable(false);
        binding.trcaddress.setFocusableInTouchMode(false);
        binding.trcaddress.setFocusable(false);
        binding.level1.setFocusableInTouchMode(false);
        binding.level1.setFocusable(false);
        binding.level2.setFocusableInTouchMode(false);
        binding.level2.setFocusable(false);
        binding.level3.setFocusableInTouchMode(false);
        binding.level3.setFocusable(false);
        binding.level4.setFocusableInTouchMode(false);
        binding.level4.setFocusable(false);
        binding.level5.setFocusableInTouchMode(false);
        binding.level5.setFocusable(false);
        binding.level6.setFocusableInTouchMode(false);
        binding.level6.setFocusable(false);
        binding.level7.setFocusableInTouchMode(false);
        binding.level7.setFocusable(false);
        binding.level8.setFocusableInTouchMode(false);
        binding.level8.setFocusable(false);
        binding.level9.setFocusableInTouchMode(false);
        binding.level9.setFocusable(false);

        binding.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editbtn.setVisibility(View.GONE);
                binding.savebtn.setVisibility(View.VISIBLE);
                binding.supportLink.setFocusableInTouchMode(true);
                binding.supportLink.setFocusable(true);
                binding.supportLink.requestFocus();
                binding.claimbalanceguide.setFocusableInTouchMode(true);
                binding.claimbalanceguide.setFocusable(true);
                binding.videotId.setFocusableInTouchMode(true);
                binding.videotId.setFocusable(true);
                binding.videoguideTXT.setFocusableInTouchMode(true);
                binding.videoguideTXT.setFocusable(true);
                binding.incomeguide.setFocusableInTouchMode(true);
                binding.incomeguide.setFocusable(true);
                binding.trcaddress.setFocusableInTouchMode(true);
                binding.trcaddress.setFocusable(true);
                binding.level1.setFocusableInTouchMode(true);
                binding.level1.setFocusable(true);
                binding.level2.setFocusableInTouchMode(true);
                binding.level2.setFocusable(true);
                binding.level3.setFocusableInTouchMode(true);
                binding.level3.setFocusable(true);
                binding.level4.setFocusableInTouchMode(true);
                binding.level4.setFocusable(true);
                binding.level5.setFocusableInTouchMode(true);
                binding.level5.setFocusable(true);
                binding.level6.setFocusableInTouchMode(true);
                binding.level6.setFocusable(true);
                binding.level7.setFocusableInTouchMode(true);
                binding.level7.setFocusable(true);
                binding.level8.setFocusableInTouchMode(true);
                binding.level8.setFocusable(true);
                binding.level9.setFocusableInTouchMode(true);
                binding.level9.setFocusable(true);

                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(binding.level1,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level2,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level3,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level4,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level5,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level6,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level7,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level8,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.level9,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.supportLink,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.incomeguide,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.claimbalanceguide,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.videotId,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.videoguideTXT,InputMethodManager.SHOW_IMPLICIT);
                inputMethodManager.showSoftInput(binding.trcaddress,InputMethodManager.SHOW_IMPLICIT);

            }
        });

        binding.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("Rainbow").child("Users").setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Reset Successful",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String supportlink = binding.supportLink.getText().toString();
                String balanceGuide = binding.claimbalanceguide.getText().toString();
                String videoId = binding.videotId.getText().toString();
                String videoguide = binding.videoguideTXT.getText().toString();
                String incomeguide = binding.incomeguide.getText().toString();
                String trc = binding.trcaddress.getText().toString();
                String level1 = binding.level1.getText().toString();
                String level2 = binding.level2.getText().toString();
                String level3 = binding.level3.getText().toString();
                String level4 = binding.level4.getText().toString();
                String level5 = binding.level5.getText().toString();
                String level6 = binding.level6.getText().toString();
                String level7 = binding.level7.getText().toString();
                String level8 = binding.level8.getText().toString();
                String level9 = binding.level9.getText().toString();
                if (supportlink.isEmpty()) {
                    binding.supportLink.setError("Plz, Enter Your Support Link");
                    binding.supportLink.requestFocus();
                    return;
                }
                if (balanceGuide.isEmpty()) {
                    binding.claimbalanceguide.setError("Plz, Enter Claim Balance Text");
                    binding.claimbalanceguide.requestFocus();
                    return;
                }
                if (videoId.isEmpty()) {
                    binding.videotId.setError("Plz, Enter Video ID");
                    binding.videotId.requestFocus();
                    return;
                }
                if (videoguide.isEmpty()) {
                    binding.videoguideTXT.setError("Plz, Enter Video Guide");
                    binding.videoguideTXT.requestFocus();
                    return;
                }
                if (incomeguide.isEmpty()) {
                    binding.incomeguide.setError("Plz, Enter Income guide");
                    binding.incomeguide.requestFocus();
                    return;
                }
                if (trc.isEmpty()) {
                    binding.trcaddress.setError("Plz, Enter TRC Address");
                    binding.trcaddress.requestFocus();
                    return;
                }
                if (level1.isEmpty()) {
                    binding.level1.setError("Plz, Enter Level 1 Amount");
                    binding.level1.requestFocus();
                    return;
                }
                if (level2.isEmpty()) {
                    binding.level2.setError("Plz, Enter Level 2 Amount");
                    binding.level2.requestFocus();
                    return;
                }
                if (level3.isEmpty()) {
                    binding.level3.setError("Plz, Enter Level 3 Amount");
                    binding.level3.requestFocus();
                    return;
                }
                if (level4.isEmpty()) {
                    binding.level4.setError("Plz, Enter Level 4 Amount");
                    binding.level4.requestFocus();
                    return;
                }
                if (level5.isEmpty()) {
                    binding.level5.setError("Plz, Enter Level 5 Amount");
                    binding.level5.requestFocus();
                    return;
                }
                if (level6.isEmpty()) {
                    binding.level6.setError("Plz, Enter Level 6 Amount");
                    binding.level6.requestFocus();
                    return;
                }
                if (level7.isEmpty()) {
                    binding.level7.setError("Plz, Enter Level 7 Amount");
                    binding.level7.requestFocus();
                    return;
                }
                if (level8.isEmpty()) {
                    binding.level8.setError("Plz, Enter Level 8 Amount");
                    binding.level8.requestFocus();
                    return;
                }
                if (level9.isEmpty()) {
                    binding.level9.setError("Plz, Enter Level 9 Amount");
                    binding.level9.requestFocus();
                    return;
                }

                binding.editbtn.setVisibility(View.VISIBLE);
                binding.savebtn.setVisibility(View.GONE);

                binding.supportLink.setFocusableInTouchMode(false);
                binding.supportLink.setFocusable(false);
                binding.supportLink.requestFocus();
                binding.claimbalanceguide.setFocusableInTouchMode(false);
                binding.claimbalanceguide.setFocusable(false);
                binding.videotId.setFocusableInTouchMode(false);
                binding.videotId.setFocusable(false);
                binding.videoguideTXT.setFocusableInTouchMode(false);
                binding.videoguideTXT.setFocusable(false);
                binding.incomeguide.setFocusableInTouchMode(false);
                binding.incomeguide.setFocusable(false);
                binding.trcaddress.setFocusableInTouchMode(false);
                binding.trcaddress.setFocusable(false);
                binding.level1.setFocusableInTouchMode(false);
                binding.level1.setFocusable(false);
                binding.level2.setFocusableInTouchMode(false);
                binding.level2.setFocusable(false);
                binding.level3.setFocusableInTouchMode(false);
                binding.level3.setFocusable(false);
                binding.level4.setFocusableInTouchMode(false);
                binding.level4.setFocusable(false);
                binding.level5.setFocusableInTouchMode(false);
                binding.level5.setFocusable(false);
                binding.level6.setFocusableInTouchMode(false);
                binding.level6.setFocusable(false);
                binding.level7.setFocusableInTouchMode(false);
                binding.level7.setFocusable(false);
                binding.level8.setFocusableInTouchMode(false);
                binding.level8.setFocusable(false);
                binding.level9.setFocusableInTouchMode(false);
                binding.level9.setFocusable(false);

                HashMap<String, Object> map = new HashMap<>();
                map.put("onlinesupporturl", supportlink);
                map.put("balanceGuide", balanceGuide);
                map.put("guide", incomeguide);
                map.put("level1", level1);
                map.put("level2", level2);
                map.put("level3", level3);
                map.put("level4", level4);
                map.put("level5", level5);
                map.put("level6", level6);
                map.put("level7", level7);
                map.put("level8", level8);
                map.put("level9", level9);
                map.put("trcAddress", trc);
                map.put("video", videoId);
                map.put("videoguide", videoguide);

                reference.child("Rainbow").updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseDatabase.getInstance().getReference().child("Rainbow").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Databasedata databasedata=snapshot.getValue(Databasedata.class);
                binding.supportLink.setText(databasedata.getOnlinesupporturl());
                binding.incomeguide.setText(databasedata.getGuide());
                binding.claimbalanceguide.setText(databasedata.getBalanceGuide());
                binding.level1.setText(databasedata.getLevel1());
                binding.level2.setText(databasedata.getLevel2());
                binding.level3.setText(databasedata.getLevel3());
                binding.level4.setText(databasedata.getLevel4());
                binding.level5.setText(databasedata.getLevel5());
                binding.level6.setText(databasedata.getLevel6());
                binding.level7.setText(databasedata.getLevel7());
                binding.level8.setText(databasedata.getLevel8());
                binding.level9.setText(databasedata.getLevel9());
                binding.trcaddress.setText(databasedata.getTrcAddress());
                binding.videoguideTXT.setText(databasedata.getVideoguide());
                binding.videotId.setText(databasedata.getVideo());
                hud.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                hud.dismiss();
                Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}