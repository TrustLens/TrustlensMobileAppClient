/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package uk.ac.abdn.trustlens.scenario1;

import android.os.Bundle;
import org.apache.cordova.*;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import uk.ac.abdn.trustlens.scenario1.R;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.app.ActionBar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;





public class MainActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }


        // RZ

        // actionbar color
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4f6778")));


        // navigationbar color
        getWindow().setNavigationBarColor(0x804f6778);
        
        // button
/*        View rootView = getWindow().getDecorView().getRootView();
        LinearLayout ll = (LinearLayout) rootView;

        Button btn = new Button(this);
        btn.setText("Manual Add");
        ll.addView(btn);
*/
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }


@Override
public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater inflater = getMenuInflater();
    // inflater.inflate(R.menu.menu1, menu);

    //inflater.inflate(getResources().getIdentifier(R.menu.menu1, "menu", getPackageName()), menu);
  
    //inflater.inflate(getResources().getIdentifier("menu1", "menu", getPackageName()), menu );
        
    menu.add(0, 0, 0, "Home");
    menu.add(0, 1, 0, "Scan");
    menu.add(0, 2, 0, "Locate");
    menu.add(0, 3, 0, "History");
    menu.add(0, 4, 0, "Settings");
    // menu.add(0, 5, 0, "About");

    return super.onCreateOptionsMenu(menu);
  }

 @Override
  public boolean onOptionsItemSelected(MenuItem item) {           

        switch (item.getItemId()) {
        case 0:
            appView.loadUrl("javascript:showScreen(\"Home\")");
            return true; 
        case 1:
            appView.loadUrl("javascript:showScreen(\"Scan\")");
            return true; 
        case 2:
            appView.loadUrl("javascript:showScreen(\"Locate\")");
            return true; 
        case 3:
            appView.loadUrl("javascript:showScreen(\"History\")");
            return true;
        case 4:
            appView.loadUrl("javascript:showScreen(\"Settings\")");
            return true;            
        case 5:
            // code for subOption1
            return true;
        case 6:
            // code for subOption2
            return true;            
        }
        return super.onOptionsItemSelected(item);
    }


  public void showAlertDialog() {
    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
    alertDialog.setTitle("Alert");
    alertDialog.setMessage("Alert message to be shown");
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    alertDialog.show();
  }
}
