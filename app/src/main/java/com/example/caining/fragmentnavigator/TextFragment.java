package com.example.caining.fragmentnavigator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {
private int p;

    public TextFragment( int p) {//测试用，实际不要这么传参数
        // Required empty public constructor
        this.p=p;
    } public TextFragment( ) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_text, container, false);
        ((TextView)inflate.findViewById(R.id.text)).setText("当前fragment"+p);
        return inflate;
    }

}
