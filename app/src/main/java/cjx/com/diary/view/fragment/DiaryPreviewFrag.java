package cjx.com.diary.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cjx.com.diary.R;
import cjx.com.diary.base.BaseFragment;
import cjx.com.diary.mode.diary.Diary;
import cjx.com.diary.presenter.impl.DiaryDetailPresenterImp;
import cjx.com.diary.util.DateUtils;
import cjx.com.diary.util.Utils;
import cjx.com.diary.view.activity.DiaryDetailActivity;

/**
 * description:
 * author: bear .
 * Created date:  2017/5/12.
 */
public class DiaryPreviewFrag extends BaseFragment {

    @BindView(R.id.et_title)
    TextView mTitleEt;
    @BindView(R.id.tv_date)
    TextView mDateTv;
    @BindView(R.id.et_content)
    TextView mContentEt;

    private String id;
    Unbinder unbinder;
    private DiaryDetailPresenterImp mPresenter;

    public static BaseFragment newInstance(String id) {
        DiaryPreviewFrag frag = new DiaryPreviewFrag();
        frag.id = id;
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DiaryDetailPresenterImp();
        mPresenter.bindView(mActivity, null);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_diary_detail_preview, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //界面跳转过来后即用id查詢日記記錄并顯示
        Diary diary_id=mPresenter.query(id);
        if(diary_id!=null){
            mTitleEt.setText(diary_id.title);
            mContentEt.setText(diary_id.content);
            mDateTv.setText(diary_id.createDate);
        }
        //綁定“保存”按鈕和事件
        TextView saveTv=((DiaryDetailActivity)mActivity).getRightTv();
        saveTv.setText("保存");
        saveTv.setOnClickListener((view1)->{
            if(mPresenter.update(getCurrentDiary())){
                Utils.showToast(mActivity,"修改成功！");
                mActivity.finish();
            }
        });
    }

    @NonNull
    private Diary getCurrentDiary() {
        Diary diary=new Diary();
        diary.uid=id;
        diary.title=getTitle();
        diary.content=getContent();
        diary.createDate= DateUtils.getCurrentTime();
        return diary;
    }

    //获取标题
    private String getTitle() {
        return mTitleEt.getText().toString().trim();
    }

    //获取内容
    private String getContent() {
        return mContentEt.getText().toString().trim();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
