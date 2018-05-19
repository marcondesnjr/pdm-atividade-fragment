package marcondesnjr.github.io.pdm_atividade_fragment_01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bf1 = this.<Button>findViewById(R.id.buttonFrag1);
        bf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                ft.replace(R.id.fragContent, FragControl.getFragment());
                ft.commit();
            }
        });

        if(savedInstanceState == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.fragContent, FragControl.getFragment());
            ft.commit();
        }

    }
}

class FragControl{

    private static boolean isPrimeiro = true;

    public static Fragment getFragment(){
        if(isPrimeiro){
            isPrimeiro = false;
            return new Fragment1();
        }else{
            isPrimeiro = true;
            return new Fragment2();
        }
    }

}
