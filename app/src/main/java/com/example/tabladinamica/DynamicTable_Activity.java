package com.example.tabladinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author David Primenko
 * @version 1.0
 *
 *
 *
 * Resources used:
 * - layout params
 * - shape
 * - color
 * - string-array
 */

public class DynamicTable_Activity extends AppCompatActivity {


    //region Fields
    private TableLayout tblHeader;
    private TableLayout tblBody;
    private TableRow.LayoutParams tbrLayoutParamsId;
    private TableRow.LayoutParams tbrLayoutParamsName;
    private TableRow.LayoutParams tbrLayoutParams;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_table);

        tblHeader = (TableLayout) findViewById(R.id.tblHeader);
        tblBody = (TableLayout) findViewById(R.id.tblBody);

        tbrLayoutParamsId = new TableRow.LayoutParams(100,TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutParamsId.setMargins(0,10,0,10);
        tbrLayoutParamsName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT);
        tbrLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        createHeader();
        createBody();
    }

    // Method wich create Table Layout Header
    public void createHeader() {
        TableRow tbrHeader = new TableRow(this); // TableRow Header
        TextView txvId = new TextView(this); // TextView ID
        TextView txvName = new TextView(this); // TextView Name

        txvId.setText(R.string.txvId); // Adding text to txvId
        txvId.setLayoutParams(tbrLayoutParamsId); // Adding layout params to txvId
        tbrHeader.addView(txvId); // Adding View to TableRow

        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(tbrLayoutParamsId);
        tbrHeader.addView(txvName);

        tblHeader.addView(tbrHeader); // Adding Table Row Header to Table Layout Header
    }

    // Method wich create Table Layout Body
    public void createBody() {
        TableRow tbrBody;
        TextView txvId;
        TextView txvName;

        String[] listName = getResources().getStringArray(R.array.listName);

        for (int i = 0; i < listName.length; i++) {
            tbrBody = new TableRow(this);
            txvId = new TextView(this);
            txvName = new TextView(this);

            txvId.setText(" " + String.valueOf((i + 1)) + " ");
            txvName.setText(listName[i]);

            txvId.setLayoutParams(tbrLayoutParamsId);
            txvId.setLayoutParams(tbrLayoutParamsName);

            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            tblBody.addView(tbrBody);
        }

    }
}
