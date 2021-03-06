package yushuangming.test01.u2.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.view.WrapContentViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class XingZuoYunShiFragment extends Fragment {
    private WrapContentViewPager vp;
    private TabLayout tl;
    private List<String> list = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyFragmentAdapter adapter;
    private View view;

    public XingZuoYunShiFragment() {
        // Required empty public constructor
    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xing_zuo_yun_shi, container, false);
        tl = (TabLayout) view.findViewById(R.id.tl);
        vp = (WrapContentViewPager) view.findViewById(R.id.vp);
        YunShiFragment yunShiFragment = new YunShiFragment("0",vp);
        YunShiFragment yunShiFragment1 = new YunShiFragment("1",vp);
        BenZhouFragment yunShiFragment2 = new BenZhouFragment("2",vp);
        BenYueFragment yunShiFragment3 = new BenYueFragment("3",vp);
        BenNianFragment yunShiFragment4 = new BenNianFragment("4",vp);
        AiQingFragment yunShiFragment5 = new AiQingFragment("5",vp);

        fragmentList.add(yunShiFragment);
        fragmentList.add(yunShiFragment1);
        fragmentList.add(yunShiFragment2);
        fragmentList.add(yunShiFragment3);
        fragmentList.add(yunShiFragment4);
        fragmentList.add(yunShiFragment5);
        list.add("今日");
        list.add("明日");
        list.add("本周");
        list.add("本月");
        list.add("本年");
        list.add("爱情");
        adapter = new MyFragmentAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp.resetHeight(0);
        tl.setTabMode(TabLayout.MODE_FIXED);
        tl.setupWithViewPager(vp);

        return view;
    }


    class MyFragmentAdapter extends FragmentStatePagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }
    }

}
