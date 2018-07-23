package in.siddhant.anetpays_customer.Login.Fragments;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.siddhant.anetpays_customer.Login.LoginActivity;
import in.siddhant.anetpays_customer.POJO.APIClient;
import in.siddhant.anetpays_customer.POJO.APIInterface;
import in.siddhant.anetpays_customer.POJO.UserResponse;
import in.siddhant.anetpays_customer.R;
import in.siddhant.anetpays_customer.Utils.CustomToast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.regEx;

public class SignUp extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    protected View view;
    private EditText fullName, lastName1, lastName2, emailID, mobileNumber, DateofBirth, password, confirmPassword;
    private TextView login;
    private Button signUpButton;
    private CheckBox terms_conditions;
    private ProgressDialog progressDialog;
    private LinearLayout linearLayout;
    private Animation shakeAnimation;
    APIInterface apiInterface;
    private DatePickerDialog datePickerDialog;
    private String DOB_DAY, DOB_MONTH, DOB_YEAR;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){

        view = layoutInflater.inflate(R.layout.fragment_signup, container, false);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        initViews();
        setListeners();
        return view;
    }

    @Override
    public void onClick(View v){

        switch (v.getId())
        {
            case R.id.signUpBtn:
                checkValidation();
                break;
            case R.id.already_user:
                new LoginActivity().replaceFragment("right");
                break;
        }

    }

    private void ShowDatePicker() {
        Calendar calendar = Calendar.getInstance();
        if (datePickerDialog == null){
            datePickerDialog = DatePickerDialog.newInstance(
                    SignUp.this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
        }
        else{
            datePickerDialog.initialize(
                    SignUp.this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
        }
        datePickerDialog.setVersion(DatePickerDialog.Version.VERSION_2);
        datePickerDialog.vibrate(true);
        datePickerDialog.showYearPickerFirst(true);
        datePickerDialog.setTitle(getString(R.string.Birthday));
        datePickerDialog.show(getActivity().getFragmentManager(), "DatePicker");

    }

    private void initViews(){


        fullName         = (EditText)view.findViewById(R.id.fullName);
        lastName1        = (EditText)view.findViewById(R.id.userlastname1);
        lastName2        = (EditText)view.findViewById(R.id.userlastname2);
        emailID          = (EditText)view.findViewById(R.id.userEmailId);
        mobileNumber     = (EditText)view.findViewById(R.id.mobileNumber);
        DateofBirth      = (EditText)view.findViewById(R.id.DateOfBirthE);
        password         = (EditText)view.findViewById(R.id.password);
        confirmPassword  = (EditText)view.findViewById(R.id.confirmPassword);
        signUpButton     = (Button)view.findViewById(R.id.signUpBtn);
        login            = (TextView)view.findViewById(R.id.already_user);
        terms_conditions = (CheckBox)view.findViewById(R.id.terms_conditions);
        linearLayout     = (LinearLayout)view.findViewById(R.id.signup_layout);
        shakeAnimation   = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        progressDialog   = new ProgressDialog(getActivity());
        
        progressDialog.setCancelable(false);
        DateofBirth.setInputType(InputType.TYPE_NULL);
        DateofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Clicked", "Clicked");
                ShowDatePicker();
            }
        });
        DateofBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.d("Clicked", "Clicked");
                    ShowDatePicker();
                }
            }
        });

        XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),xrp);
            login.setTextColor(csl);
            terms_conditions.setTextColor(csl);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void setListeners(){
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    private void checkValidation(){
        String getFullName        = fullName.getText().toString();
        String getEmailID         = emailID.getText().toString();
        String getMobileNumber    = mobileNumber.getText().toString();
        String getLocation        = DateofBirth.getText().toString();
        String getPassword        = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();
        String getLastName        = lastName1.getText().toString();
        String getLastName2       = lastName2.getText().toString();
        String getdob_day         = DOB_DAY;
        String getdob_year        = DOB_YEAR;
        String getdob_month       = DOB_MONTH;

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(getEmailID);

        if (getFullName.equals("") || getFullName.length() == 0
                || getEmailID.equals("") || getEmailID.length() == 0
                || getMobileNumber.equals("") || getMobileNumber.length() == 0
                || getLocation.equals("") || getLocation.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0
                || getLastName.length() == 0
                || getLastName2.length() == 0
                || getdob_day.length() == 0)
        {
            linearLayout.startAnimation(shakeAnimation);

            new CustomToast().showToast(getActivity(), view,
                    "All fields are required.");
        }

        // Check if email id valid or not
        else if (!matcher.find())
        {
            new CustomToast().showToast(getActivity(), view,"Your Email Id is Invalid.");
        }
        else if (!getConfirmPassword.equals(getPassword)) {

            new CustomToast().showToast(getActivity(), view,"Both password doesn't match.");
        }
        else if (!terms_conditions.isChecked())
        {
            new CustomToast().showToast(getActivity(), view,"Please select Terms and Conditions.");
        }
        else

        {
            progressDialog.setMessage("Registering ......");
            showDialog();
            registerProcess(getFullName, getEmailID, getPassword, getLastName, getLastName2, getdob_day, getdob_month, getdob_year, getMobileNumber);
        }
    }

    private void registerProcess(String name, String email, String password,String lastname1, String lastname2, String dob_day, String dob_month, String dob_year, String cellphone){



        Call <UserResponse>userResponseCall = apiInterface.LoginAttempt(email, lastname1, lastname2, name, dob_day, dob_month, dob_year, cellphone, password);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse.getUpdatedRows().equalsIgnoreCase("1") && userResponse.getStatusCode().equalsIgnoreCase("200")  )
                {
                    Log.d("Hurray", "updated");
                    hideDialog();
                    new LoginActivity().replaceFragment("right");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("noooooooooooooo", "noooooooooooottttttttttttt updated");
            }
        });


    }

    private void showDialog(){
        if (!progressDialog.isShowing() && getActivity().getWindow().getDecorView().isShown())
        {
            progressDialog.show();
        }
    }

    private void hideDialog(){
        if (progressDialog.isShowing() && getActivity().getWindow().getDecorView().isShown())
        {
            progressDialog.hide();
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        DOB_DAY = String.valueOf(dayOfMonth);
        DOB_MONTH = String.valueOf(monthOfYear);
        DOB_YEAR = String.valueOf(year);
        String Date = DOB_DAY+"/"+DOB_MONTH+"/"+DOB_YEAR;
        DateofBirth.setText(Date);

    }
}
