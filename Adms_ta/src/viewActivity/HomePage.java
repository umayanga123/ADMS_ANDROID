package viewActivity;

import com.src.adms_ta.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends Activity implements OnClickListener {

	private Button btLogOut;
	private Button btDeseaseSend;
	private Button btUpgrade;
	private Button btViewHistory;
	private Button btInternet;

	private String userName;
	private String userType;
	private String password;
	
	//private TextView titleTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		setInitComponent();
	}

	private void setInitComponent() {
		// TODO Auto-generated method stub
		Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Bamini.ttf");
		
		btLogOut = (Button) findViewById(R.id.btLogOut);
		btDeseaseSend = (Button) findViewById(R.id.btDiseaseSend);
		btUpgrade = (Button) findViewById(R.id.btUpgrade);
		btViewHistory = (Button) findViewById(R.id.btHistory);
		btInternet = (Button) findViewById(R.id.btInternet);

		btLogOut.setOnClickListener(this);
		btDeseaseSend.setOnClickListener(this);
		btUpgrade.setOnClickListener(this);
		btViewHistory.setOnClickListener(this);
		btInternet.setOnClickListener(this);

		btDeseaseSend.setTypeface(custom_font);
        btDeseaseSend.setText("Neாa;fs; mwpf;if");
        
        btUpgrade.setTypeface(custom_font);
        btUpgrade.setText("Ratpguk; Nkk;gLj;jy;");
        
        btViewHistory.setTypeface(custom_font);
        btViewHistory.setText("fle;j EioT");
        
        btInternet.setTypeface(custom_font);
        btInternet.setText("ADMS jsk;");
		
		Bundle extras = getIntent().getExtras();
		userName = extras.getString("user_name");
		userType = extras.getString("user_type");
		password = extras.getString("pass_word");

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btLogOut:
			finish();
			Intent logIntent = new Intent(HomePage.this, LogIn.class);
			startActivity(logIntent);
			break;

		case R.id.btDiseaseSend:
			// call for Special activity
			//Toast.makeText(HomePage.this, userName + " : " + userType,Toast.LENGTH_SHORT).show();
			if(userType.equals("Special User")){
				Intent diseDetailIntent = new Intent(HomePage.this, Send_deases_Detail.class);
				diseDetailIntent.putExtra("user_name", userName);
				diseDetailIntent.putExtra("pass_word", password);
				startActivity(diseDetailIntent);
			}else{
				Toast.makeText(HomePage.this, userName + " : " + userType +"\nPlease upgrade your profile to use this function.",Toast.LENGTH_LONG).show();
			}
			break;

		case R.id.btUpgrade:
			if(userType.equals("General User")){	
				Intent regIntent = new Intent(HomePage.this, SpecialRegistor.class);
				regIntent.putExtra("status","login");
				regIntent.putExtra("user_type", userType);
				regIntent.putExtra("user_name", userName);
				regIntent.putExtra("pass_word", password);
				startActivity(regIntent);
			}else{
				Toast.makeText(HomePage.this, userName + " : " + userType +"\nYou are all ready registor to speacial user or your request in pending..!",Toast.LENGTH_LONG).show();
			}
			
			break;

		case R.id.btHistory:
			// call for Special activity
			if(userType.equals("Special User")){
				Intent histryIntent = new Intent(HomePage.this, HistoryOfSendDesease.class);
				histryIntent.putExtra("user_name", userName);
				histryIntent.putExtra("pass_word", password);
				startActivity(histryIntent);
			}else{
				Toast.makeText(HomePage.this, userName + " : " + userType +"\nPlease upgrade your profile to use this function.",Toast.LENGTH_LONG).show();
			}
			
			break;

		case R.id.btInternet:
			Intent regIntent = new Intent(HomePage.this, SimpleBrowser.class);
			startActivity(regIntent);
			break;
		default:
			break;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.quick_menu, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent aboutView = new Intent(HomePage.this , AboutUS.class);
			startActivity(aboutView);
			break;
		case R.id.contactUs:
			Intent contactView = new Intent(HomePage.this , ContactUS.class);
			startActivity(contactView);
			break;

		case R.id.setting:
			//Intent settingView = new Intent(HomePage.this , Setting.class);
			//startActivity(settingView);
			break;
			
		case R.id.help:
			Intent helpView = new Intent(HomePage.this , Help.class);
			startActivity(helpView);
			break;
			
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}

}
