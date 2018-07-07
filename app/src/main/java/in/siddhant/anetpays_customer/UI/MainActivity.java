package in.siddhant.anetpays_customer.UI;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.omadahealth.lollipin.lib.PinCompatActivity;
import com.github.omadahealth.lollipin.lib.managers.AppLock;
import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.crossfader.util.UIUtils;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.List;

import in.siddhant.anetpays_customer.POJO.APIClient;
import in.siddhant.anetpays_customer.POJO.APIInterface;
import in.siddhant.anetpays_customer.POJO.User;
import in.siddhant.anetpays_customer.R;
import in.siddhant.anetpays_customer.Utils.CrossfadeWrapper;
import in.siddhant.anetpays_customer.Utils.CustomPinActivity;
import in.siddhant.anetpays_customer.Utils.RuntimePermissionUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.EMAIL_PROFILE;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.NAME_PROFILE;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.PREF_FIRST_RUN;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.PREF_LOGIN;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.PREF_MISC;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.UNIQUE_ID;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.URL_PROFILE;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.hasCameraPer;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.isFIRSTrun;

public class MainActivity extends PinCompatActivity{

    private Drawer drawerResult = null;
    private AccountHeader accountHeader = null;
    private MiniDrawer miniDrawer = null;
    private Crossfader crossfader;
    private FragmentManager fragmentManager;
    public Fragment fragment;
    private static final int REQUEST_CODE_ENABLE = 11;
    private static final String cameraPermission = Manifest.permission.CAMERA;
    private Snackbar snackbar;
    private CoordinatorLayout coordinatorLayout;
    APIInterface apiInterface;
    private static SharedPreferences sharedPreferences, sharedPreferences_edit;
    private ProgressDialog progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        downloadData();
        checks();
        setContentView(R.layout.main_activity);
        sharedPreferences_edit = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        final IProfile profile = new ProfileDrawerItem()
                .withName(sharedPreferences_edit.getString(NAME_PROFILE, "NAME"))
                .withEmail(sharedPreferences_edit.getString(EMAIL_PROFILE, "EMAIL"))
                .withIcon(sharedPreferences_edit.getString(URL_PROFILE, ""));

        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withTranslucentStatusBar(false)
                .addProfiles(
                        profile
                )
                .withSelectionListEnabledForSingleProfile(false)
                .withSavedInstance(savedInstanceState)
                .build();

        drawerResult = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.pay).withIcon(GoogleMaterial.Icon.gmd_monetization_on).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.profile).withIcon(GoogleMaterial.Icon.gmd_person).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.transaction).withIcon(GoogleMaterial.Icon.gmd_history).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.cards).withIcon(GoogleMaterial.Icon.gmd_credit_card).withIdentifier(4),
                        new SectionDrawerItem().withName(R.string.extras),
                        new SecondaryDrawerItem().withName(R.string.about).withIcon(GoogleMaterial.Icon.gmd_cached).withIdentifier(5),
                        new SecondaryDrawerItem().withName(R.string.help).withIcon(GoogleMaterial.Icon.gmd_help).withIdentifier(6)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .withGenerateMiniDrawer(true)
                .withSavedInstance(savedInstanceState)
                .buildView();

        miniDrawer = drawerResult.getMiniDrawer();

        int firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        int secondWidth = (int) UIUtils.convertDpToPixel(72, this);

        crossfader = new Crossfader()
                .withContent(findViewById(R.id.crossfade_content))
                .withFirst(drawerResult.getSlider(), firstWidth)
                .withSecond(miniDrawer.build(this), secondWidth)
                .withSavedInstance(savedInstanceState)
                .build();

        miniDrawer.withCrossFader(new CrossfadeWrapper(crossfader));
        crossfader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
    }

    private void downloadData() {

        sharedPreferences = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        sharedPreferences_edit = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences_edit.edit();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.getUserList(sharedPreferences.getString(UNIQUE_ID, "qwe"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User resource = response.body();
                List<User.UserData> datumList =  resource.getData();
                for (User.UserData datum : datumList){
                    editor.putString(NAME_PROFILE, datum.getNames());
                    editor.putString(EMAIL_PROFILE, datum.getUserEmail());
                    if (datum.getProfilePicUri() == null){
                        editor.apply();
                    }else {
                        editor.putString(URL_PROFILE, datum.getProfilePicUri().toString());
                        editor.apply();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_ENABLE:
                Toast.makeText(this, "PinCode enabled", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void checks() {

        Boolean isFirstRun = getSharedPreferences(PREF_FIRST_RUN, MODE_PRIVATE).getBoolean(isFIRSTrun, true);
        if (isFirstRun){
            Intent intent = new Intent(this, CustomPinActivity.class);
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
            startActivityForResult(intent, REQUEST_CODE_ENABLE);
            getSharedPreferences(PREF_FIRST_RUN, MODE_PRIVATE).edit().putBoolean(isFIRSTrun, false).apply();
        }
        else{
            Log.d("Error", "First Run Block");
            Thread.dumpStack();
        }
        Boolean hasCameraPermission = getSharedPreferences(PREF_MISC, MODE_PRIVATE).getBoolean(hasCameraPer, false);
        if (hasCameraPermission){
            Log.d("Success", "Camera Permission Granted already");
        }
        else
        {
            try{
                RuntimePermissionUtil.requestPermission(MainActivity.this, cameraPermission, 100);
                Log.d("Success", "Camera Permission Granted");
            }
            catch (Exception e)
            {
                Log.d("Error", "Camera Permission NOT Granted", e);
                snackbar = Snackbar.make(coordinatorLayout, "Could not Take camera permission", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }
    }

}
