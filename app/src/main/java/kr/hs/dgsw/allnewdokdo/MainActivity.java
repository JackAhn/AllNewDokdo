package kr.hs.dgsw.allnewdokdo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.hs.dgsw.allnewdokdo.db.DokdoBean;
import kr.hs.dgsw.allnewdokdo.db.DokdoDBHelper;

public class MainActivity extends AppCompatActivity {

    public static DokdoDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DokdoDBHelper(this, "dokdodb", null, 1);
        addData();
    }

    public void onClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case R.id.inforBtn:
                intent = new Intent(this, InforActivity.class);
                startActivity(intent);
                break;
            case R.id.natureBtn:
                intent = new Intent(this, NatureActivity.class);
                startActivity(intent);
                break;
            case R.id.historyBtn:
                intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.exitBtn:
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }

    private void addData(){
        helper.insert(new DokdoBean("자연관", R.drawable.nature1,"괭이갈매기는 이름 그대로 고양이 울음소리 같은 소리를 냅니다.\n그리고 독도에 많이 서식하는 동물 중 하나입니다."));
        helper.insert(new DokdoBean("자연관", R.drawable.nature2,"용치놀래기는 식탐이 강하기로 유명합니다.\n그래서 먹이인 성게나 멍게 주변에서 흔히 볼 수 있습니다."));
        helper.insert(new DokdoBean("독도소개", R.drawable.infor1, "독도는 460만년전 형성된 것으로 추정됩니다.\n이는 울릉도와 제주도보다 훨씬 오래 된 화산섬입니다.\n독도는 천연기념물 제336호 독도해조류번식지이며\n현재는 독도천연보호구역으로 명칭이 변경되었습니다."));
        helper.insert(new DokdoBean("독도캐릭터", R.drawable.infor2, "독도랑 캐릭터는 동도와 서도를 친근하게 표현한 것입니다.\n초록색 섬은 명량하고 강직한 성품을 가진 서도이며,\n노란색 섬은 독도 대표 식물인 왕해국을 지닌 동도입니다."));
        helper.insert(new DokdoBean("독도캐릭터", R.drawable.infor3, "태장군 캐릭터는 신라장군 이사부를 표현하였습니다.\n이사부는 지금의 울릉도를 신라땅으로 만든 장군입니다."));
        helper.insert(new DokdoBean("독도캐릭터", R.drawable.infor4, "안장군 캐릭터는 안용복 선생의 활동 모습을 재연했습니다.\n안용복은 두 번에 걸친 도일을 통해\n독도가 조선의 용토라는 의식을 고취시켰습니다."));
        helper.insert(new DokdoBean("독도캐릭터", R.drawable.infor5, "홍대장 캐릭터는 울릉도 주민 홍순칠 씨를 표현했습니다.\n홍순칠 씨는 독도수비대를 결성해\n일본의 독도 불법 점령을 막아냈습니다."));
        helper.insert(new DokdoBean("독도캐릭터", R.drawable.infor6, "아라 캐릭터는 한 때 독도에서\n4만 마리나 서식했던 강치를 표현하였습니다.\n하지만 일제강점기 이후 개체 수가 급감하여\n2011년에 공식적으로 멸종되었습니다."));
        helper.insert(new DokdoBean("독도소개", R.drawable.infor7, "독도가 외관상으로는 작아 보이지만\n화산체는 적어도 2,000m가 넘을 것으로 추정됩니다."));
        helper.insert(new DokdoBean("독도소개", R.drawable.infor8, "독도는 강한 해풍과 척박한 토질로 환경조건이 좋지 않지만\n지금까지 59종류가 자생하는 것으로 관찰되었습니다."));
        helper.insert(new DokdoBean("독도소개", R.drawable.infor9, "독도에는 어민 관련시설, 군사시설, 도로, 수자원 확보시설,\n유류저장시설, 식품저장시설, 기상관측시설,\n등대시설, 탑, 표석 등이 있습니다."));
        helper.insert(new DokdoBean("찾아오시는 길", R.drawable.infor10, "독도에 방문하기 위해서는 사전 입도 신청을 해야 합니다.\n독도 접안시설만 탐방하는 일반 입도와\n기반시설까지 탐방하는 특수목적 입도가 있습니다."));
        helper.insert(new DokdoBean("찾아오시는 길", R.drawable.infor11, "먼저, 울릉도에 도착하신 후 저동항에서 배를 갈아탑니다.\n엘도라오호 기준 왕복 소요시간은 4시간입니다.\n예매는 인터넷에서 예매가 가능합니다."));
    }

}
