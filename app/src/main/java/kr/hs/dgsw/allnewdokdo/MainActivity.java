package kr.hs.dgsw.allnewdokdo;

import android.content.Intent;
import android.os.Environment;
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
        helper.resetDB();
        helper.createDB();
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
        helper.insert(new DokdoBean("자연관", R.drawable.nature3, "파랑돔은 보통 인도양에서 발견되지만\n독도에서도 서식하는 물고기입니다.\n길이는 30cm 정도이며, 몸빛은 전체적으로 파란색입니다."));
        helper.insert(new DokdoBean("자연관", R.drawable.nature4, "청줄돔은 옆으로 납작하며, 몸이 계란 모양입니다.\n수심 5 ~ 15m인 연안의 돌이나 암초로 된 지역에 서식합니다."));
        helper.insert(new DokdoBean("자연관", R.drawable.nature5, "붉은가시딸기는 주로 나무 밑이나 그늘진 습지에서 자랍니다.\n높이는 약 2 ~ 3m 정도가 되며,\n작은잎과 잎자루에 털이 많이 납니다."));
        helper.insert(new DokdoBean("자연관", R.drawable.nature6, "삽살개는 독도 경비대가 키우고 있는 유일한 포유류라고 합니다.\n1992년에 천연기념물 제368호로 공인되었으며,\n잡귀를 쫓는 퇴마견으로도 알려져 있습니다."));
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
        helper.insert(new DokdoBean("지명", R.drawable.history1, "신라 지증왕 13년 이사부 장군이 섬을 점령하였습니다.\n이 후, 점령한 섬의 이름을 우산국이라고 정했습니다.\n우산은 고구려말에서 웃쪽의 높은 산이라는 뜻입니다.\n(512년)"));
        helper.insert(new DokdoBean("지명", R.drawable.history2, "조선 성종 7년에 삼봉도(독도)를 찾으라고 했습니다.\n사람들은 이 섬에 사람 모습이 30개나 되어\n 두렵다고 자세히 조사하지 못하고 왔습니다.\n삼봉도는 세 개의 봉우로 된 섬이라는 뜻입니다.\n(1471년)"));
        helper.insert(new DokdoBean("지명", R.drawable.history3, "가지도라는 이름은 18세기부터 불리기 시작했으며,\n가지는 물개라는 말로서 물개가 많은 섬이라는 뜻입니다.\n(1794년)"));
        helper.insert(new DokdoBean("지명", R.drawable.history4, "19세기 말부터 지금의 이름인 독도로 불리기 시작했습니다.\n여기서 독이라는 말은 경상도, 전라도지방 사투리로서\n돌을 독으로 부른데에서 유래되었습니다.\n(1906년)"));
        helper.insert(new DokdoBean("역사 속 인물", R.drawable.history5, "독도와 관련하여 역사상 처음으로 등장한 인물인 이사부는\n우산국을 굴복시키기 위해 허수아비 사자를 만들어서\n우산국 사람들이 항복하도록 했습니다."));
        helper.insert(new DokdoBean("역사 속 인물", R.drawable.history6, "외교가인 안용복이 없었다면 울릉도, 독도는\n우리땅으로 존재하지 않았을 것입니다.\n일본이 자꾸 울릉도, 독도에 발을 내딛을려고 하자\n안용복이 직접 일본으로 건너가\n다시는 오지 말라고 담판을 벌였습니다."));
        helper.insert(new DokdoBean("역사 속 인물", R.drawable.history7, "6.25의 혼란 속에서 일본인들은\n우리 어부의 위령비를 파괴하는 등\n불법행위를 엄청나게 많이 저질렀습니다.\n이 상황에서 독도의용수비대가 결성되고,\n사람들이 독도를 지키게 되었습니다.\n이들은 일본의 흔적을 제거했으며,\n위장 대포를 만들어 일본인들을 쫒기도 했습니다."));
        helper.insert(new DokdoBean("역사 속 인물", R.drawable.history8, "독도주민등록 1호인 최종덕씨는 당시 무인도였던\n독도를 인간의 냄새가 나는 섬으로 만들었습니다.\n그는 시설물 건립 등의 활동을 하였습니다.\n그는 1987년 9월 23일에 사망했습니다."));
    }

}
