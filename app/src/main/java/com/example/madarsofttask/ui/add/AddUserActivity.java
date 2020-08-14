package com.example.madarsofttask.ui.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.madarsofttask.R;
import com.example.madarsofttask.ui.list.ListUsersActivity;

public class AddUserActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText userName, userAge, userTitle;
    private String userGender;
    private Button btnSave, btnDisplay;
    private AddUserViewModel addUserViewModel;
    private Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initUi();
        setupGenderSpinner();
        watchEditTextChanges();
        initViewModel();
        handleSaveButton();
        handleDisplayButton();
    }

    private void watchEditTextChanges() {
        userName.addTextChangedListener(addUserTextWatcher);
        userAge.addTextChangedListener(addUserTextWatcher);
        userTitle.addTextChangedListener(addUserTextWatcher);
    }

    private void setupGenderSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);
        genderSpinner.setOnItemSelectedListener(this);
    }

    private TextWatcher addUserTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = userName.getText().toString().trim();
            String ageInput = userAge.getText().toString().trim();
            String titleInput = userTitle.getText().toString().trim();
            btnSave.setEnabled(!usernameInput.isEmpty() && !ageInput.isEmpty() && !titleInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void handleDisplayButton() {
        btnDisplay.setOnClickListener(view -> startActivity(new Intent(AddUserActivity.this, ListUsersActivity.class)));
    }

    private void handleSaveButton() {
        btnSave.setOnClickListener(view -> {
            double age = Double.parseDouble(userAge.getText().toString());
            String name = userName.getText().toString();
            String title = userTitle.getText().toString();
            String gender = userGender;
            addUserViewModel.addUser(name, title, age, gender);
            handleUserAdded();
        });
    }

    private void handleUserAdded() {
        Toast.makeText(AddUserActivity.this, getString(R.string.user_added_successfully), Toast.LENGTH_SHORT).show();
        clearForm();
    }

    private void clearForm() {
        userAge.setText("");
        userName.setText("");
        userTitle.setText("");
    }

    private void initViewModel() {
        addUserViewModel = new ViewModelProvider(this).get(AddUserViewModel.class);
    }

    private void initUi() {
        userName = findViewById(R.id.name_editText);
        userAge = findViewById(R.id.age_editText);
        userTitle = findViewById(R.id.title_editText);
        genderSpinner = findViewById(R.id.gender_spinner);
        btnSave = findViewById(R.id.save_btn);
        btnDisplay = findViewById(R.id.display_button);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        userGender = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
