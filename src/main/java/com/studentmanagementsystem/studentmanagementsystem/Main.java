package com.studentmanagementsystem.studentmanagementsystem;

//import com.example.tray1.classes.Teacher;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    static File userIconFile = new File("src\\images\\user.png");
    static ImageView userIcon = new ImageView(new Image(userIconFile.getAbsolutePath()));
    static File accImgFile = new File("src\\images\\user.png");
    static ImageView accountIcon = new ImageView(new Image(accImgFile.getAbsolutePath()));
    static File subImgFile = new File("src\\images\\sub.png");
    static ImageView subjectsIcon = new ImageView(new Image(subImgFile.getAbsolutePath()));
    static File feedImgFile = new File("src\\images\\feedback.png");
    static ImageView feedImg = new ImageView(new Image(feedImgFile.getAbsolutePath()));
    static File platImgFile = new File("src\\images\\platform.png");
    static ImageView platformIcon = new ImageView(new Image(platImgFile.getAbsolutePath()));
    static File logOutBtnImgFile = new File("src\\images\\logout.png");
    static ImageView logOutImg = new ImageView(new Image(logOutBtnImgFile.getAbsolutePath()));
    static File attImgFile = new File("src\\images\\attendance.png");
    static ImageView attendanceIcon = new ImageView(new Image(attImgFile.getAbsolutePath()));


    /* :: Declaring And Initializing Some Students :: */
    static Student student1 = new Student("Ahmed","Emad","ahmedemad022","Secondary",
            1,"Electrical","ahmedemad@zu.com","12345");
    static Student student2 = new Student("Ahmed","Ismail","ismail022","Secondary",
            2,"Electrical","ismail022@zu.com","12345");
    static Student student3 = new Student("Ahmed","Mohamed","ahmedmohamed022","Secondary",
            3,"Electrical","ahmedmohamed022@zu.com","12345");
    static Student student4 = new Student("Emad","Ahmed","emad022","Secondary",
            4,"Electrical","emad022@zu.com","12345");
    static Student student5 = new Student("Mohamed","Hamdi","hamdi022","Secondary",
            5,"Electrical","hamdi022@zu.com","12345");
    static Student student6 = new Student("Mohamed","Sobhy","sobhy022","Secondary",
            6,"Electrical","sobhy022@zu.com","12345");
    static Student student7 = new Student("Mahmoud","Attia","attia022","Secondary",
            7,"Electrical","attia022@zu.com","12345");
    static Student student8 = new Student("Mostafa","Asaad","mostafa022","Secondary",
            8,"Electrical","mostafa022@zu.com","12345");
    static Student student9 = new Student("Nancy","Mosaad","nancy022","Secondary",
            9,"Electrical","nancy022@zu.com","12345");
    /* :: End :: */
    static HBox hBox2 = new HBox(20);//For Teacher
    static HBox hBoxx = new HBox(20); //For Admin
    static HBox hBox = new HBox(20); //Base Container For Admin
    static Button signUpBtn = new Button("Sign Up");
    static VBox vAll = new VBox(10);

    /* :: Login page :: */
    public static void loginPage ()
    {
        Stage loginStage = new Stage();
        loginStage.setTitle("Login Page");
        /* ::[1] Creating Welcome Label and adding it to a container : : */
        //Creating A Welcome Label
        Label welcome = new Label("Welcome");
        //Setting The Welcome Message Style
        welcome.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,48)); // FONT Color And Size
        welcome.setTextFill(Color.RED);    // Give It Red Color
        FlowPane welcomeCont = new FlowPane(welcome);   // CONTAINER FOR THE WELCOME MESSAGE
        welcomeCont.setPadding(new Insets(50,0,30,55));
        welcomeCont.setAlignment(Pos.CENTER);  // Puts it in the center of Its container
        /* :: End [1] ::*/
        /* :: [2] THE LOGIN TextFIELDS AND LABELS :: */
        // 1-USERNAME Label
        Label username = new Label("Username");
        username.setFont(Font.font(16));    // Size
        TextField user = createUsernameField(); // Call the 2-fun above
        // 2-PASSWORD FIELD
        Label password = new Label("Password");
        password.setFont(Font.font(16));   // Size
        PasswordField pass = createPasswordField(); // Call the 3-fun above

        // 3-CREATING TOGGLE GROUP Of --> Radio Buttons <-- TO CHOOSE THE SIGNING IN MODE
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton std = new RadioButton("Student");
        std.setCursor(Cursor.HAND);
        RadioButton tch = new RadioButton("Teacher");
        tch.setCursor(Cursor.HAND);
        RadioButton admin = new RadioButton("Administrator");
        admin.setCursor(Cursor.HAND);
        std.setSelected(true);   //default
        std.setToggleGroup(toggleGroup);
        tch.setToggleGroup(toggleGroup);
        admin.setToggleGroup(toggleGroup);
        HBox chs = new HBox(6);
        chs.getChildren().addAll(std,tch,admin);
        chs.setPadding(new Insets(9,0,0,0));
        //3'-Creating a Combobox of Subjects For The Teacher Login
        HBox subjectsBox = new HBox();
        subjectsBox.setPadding(new Insets(5));
        ComboBox <String> subjectsCombo = new ComboBox<>();
        subjectsCombo.getItems().addAll("Mathematics", "Humanities", "Chemistry",
                "Programming", "Physics");
        subjectsCombo.setValue("Subject");
        subjectsCombo.setMaxWidth(250);
        subjectsCombo.setMinHeight(30);
        subjectsBox.getChildren().add(subjectsCombo);
        subjectsCombo.setCursor(Cursor.HAND);
        // 4-LOGIN BUTTON
        FlowPane logBtnCont = new FlowPane();
        Button logBtn = new Button("Login");
        logBtnCont.getChildren().add(logBtn);
        logBtnCont.setPadding(new Insets(9,0,0,0));
        logBtn.setPrefSize(250,30);
        logBtn.setFont(Font.font(16));
        logBtn.setTextFill(Color.WHITE);
        logBtn.setBackground(new Background(new BackgroundFill(Color.web("#00A0BD"),
                new CornerRadii(25),null)));
        logBtn.setCursor(Cursor.HAND);
        /* :: End [2] :: */
        /* :: End [4] :: */
        //ADDING ALL THE ELEMENTS TO THE LOGIN FIELD VBOX
        VBox loginField = new VBox();
        loginField.setPrefSize(150,540);
        loginField.setSpacing(4);
        loginField.getChildren().addAll(username, user, password, pass, chs, logBtnCont
                , createSeparator());
        VBox loginCont = new VBox();
        loginCont.setPrefSize(330,580); //  Preferred size
        loginCont.getChildren().addAll(welcomeCont,loginField);
        loginField.setPadding(new Insets(0, 0, 0, 40));
        tch.setOnAction(e-> {
            loginField.getChildren().clear();
            loginField.getChildren().addAll(username, user, password, pass, chs,subjectsBox, logBtnCont
                    , createSeparator());
        });
        std.setOnAction(e-> {
            loginField.getChildren().clear();
            loginField.getChildren().addAll(username, user, password, pass, chs, logBtnCont
                    , createSeparator());
        });
        admin.setOnAction(e->{ loginField.getChildren().clear();
            loginField.getChildren().addAll(username, user, password, pass, chs, logBtnCont
                    , createSeparator());
        });
        /* :: [5] Creating The Final Layout For The Login Page :: */
        HBox h = new HBox(loginCont);
        //backGround Image
        File backGroundImageFile = new File("src\\images\\background.png");
        h.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundImage(
                new Image(backGroundImageFile.getAbsolutePath()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                javafx.scene.layout.BackgroundPosition.CENTER,
                new javafx.scene.layout.BackgroundSize(h.getWidth(),
                        h.getHeight(), false, false, false, true))));

        /* :: End [5] :: */
        Scene s = new Scene(h, 1000, 600);
        loginStage.setScene(s);
        loginStage.show();
        //The Action Of The Login Button
        logBtn.setOnAction(event -> {
            loginBtnAction(loginStage, user, pass, std, tch, admin, subjectsCombo);
        });
        pass.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                loginBtnAction(loginStage, user, pass, std, tch, admin, subjectsCombo);
            }
        });
    }
    private static void loginBtnAction(Stage loginStage, TextField user, PasswordField pass,
                                       RadioButton std, RadioButton tch, RadioButton admin, ComboBox<String> subjectsCombo) {
        if (user.getText().isEmpty() || pass.getText().isEmpty()) {    //<<<<<<<<<<<<<<<<<<<<<<<<<<<
            Alert alertt = new Alert(Alert.AlertType.ERROR);
            alertt.setHeaderText("Can't LogIn");
            alertt.setContentText("You have to enter your username and password");
            alertt.show();
        } else {
            if (std.isSelected()) {
                Student newStudent = new Student();
                newStudent.setUserName(user.getText());
                newStudent.setFirstName(user.getText());
                newStudent.setSecondName(" ");
                newStudent.setId(0);
                newStudent.setEmail("sudent@edu.com");
                newStudent.setPassword(pass.getText());
                studentDashboard(newStudent);
                loginStage.close();
            } else if (tch.isSelected()) {
                loginStage.close();
                Teacher teacher = new Teacher();
                teacher.setLogInfo(user.getText(), pass.getText());
                teacher.setFirstName(user.getText());
                teacher.setSubject(subjectsCombo.getSelectionModel().getSelectedItem());
                teacherDashboard(teacher);
            } else if (admin.isSelected()) {
                loginStage.close();
                administratorDashboard();
            }
        }
    }
    /* :: End Of Login Page :: */

    /* :: Student Dashboard :: */
    static void studentDashboard (Student newStudent)
    {
        Stage studentStage = new Stage();
        studentStage.setTitle("Student");
        /* :: User Name And Photo :: */
        userIcon.setFitWidth(50);
        userIcon.setFitHeight(50);
        Label name = new Label(newStudent.getUserName());
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font(22));
        FlowPane userData = new FlowPane(userIcon,name);
        userData.setPadding(new Insets(0,0,10,0));
        //::Student SideBar Buttons:://
        /* :: Account Button :: */
        Button accountBtn = createSideBarButtons();
        accountBtn.setText(" Account");
        FlowPane accBtn_cont = new FlowPane(accountBtn);
        accountIcon.setFitHeight(20);
        accountIcon.setFitWidth(20);
        accountBtn.setGraphic(accountIcon);
        /* :: Subjects Button :: */
        Button subBtn = createSideBarButtons();
        subBtn.setText(" Subjects");
        FlowPane subBtn_cont = new FlowPane(subBtn);
        subBtn.setGraphic(subjectsIcon);
        /* :: Feedback Button :: */
        Button feedBtn = createSideBarButtons();
        feedBtn.setText(" Feedback");
        FlowPane feedBtn_cont = new FlowPane(feedBtn);
        feedBtn.setGraphic(feedImg);
        /* :: University Platform Button :: */
        Button platform = createSideBarButtons();
        platform.setText(" University Platform");
        platform.setOnAction(event -> {
            try {
                String url = "http://admineng.eps.zu.edu.eg/Views/StudentViews/ESubjectsExams";
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        platform.setGraphic(platformIcon);
        FlowPane platform_cont = new FlowPane(platform);
        /* ::  Logout Button :: */
        Button logOutBtn = createSideBarButtons("Log Out ");
        logOutBtn.setGraphic(logOutImg);
        FlowPane logout_cont = new FlowPane(logOutBtn);
        logOutBtn.setOnAction(e-> {
            vAll.getChildren().clear();
            studentStage.close();
            newStudent.clearData();
            loginPage();
        });
        /* --> Creating The Container Of the Sidebar :: <--*/
        VBox v = new VBox();
        v.setMaxWidth(250);
        v.setMinHeight(580);
        //  Creating And Styling The Sidebar background ::
        BackgroundFill sidebar_backgroundFill = new BackgroundFill(Color.web("#23252b"),
                new CornerRadii(0,50,50,0,false),null); // Setting The Color And the Curves
        Background sidebar_background = new Background(sidebar_backgroundFill);
        v.setBackground(sidebar_background);
        v.setAlignment(Pos.TOP_CENTER);
        v.setPadding(new Insets(50,0,10,10));
        v.setSpacing(20);
        v.getChildren().addAll(userData,accBtn_cont,subBtn_cont,feedBtn_cont,platform_cont,logout_cont); //Adding All The Elements to The VBox
        //creating A layout contains all the components//
        HBox h = new HBox(150);
        h.setPadding(new Insets(5,10,5,10));
        //**account button Action**//
        accountBtn.setOnAction( e-> {
            //buttons to confirm the changes//
            Label noteLabel = new Label("*make sure you type your\n current Password correctly\n before clicking save*");
            noteLabel.setFont(Font.font(null,null,FontPosture.ITALIC,12));
            noteLabel.setTextFill(Color.RED);
            Button bsave = new Button("Save changes");
            Button bcancel = new Button("Cancel");
            bsave.setTextFill(Color.BLUEVIOLET);
            bcancel.setTextFill(Color.BLUEVIOLET);
            bsave.setCursor(Cursor.HAND);
            bcancel.setCursor(Cursor.HAND);
            VBox vbuttons = new VBox(10);
            vbuttons.getChildren().addAll(noteLabel,bsave,bcancel);
            //current information//
            Label lblcurrentinfo = new Label("Your current information :");
            setStyle3(lblcurrentinfo);
            Label lbluser1 = new Label(newStudent.getUserName());
            setStyle(lbluser1);
            Label lblfirst = new Label(newStudent.getFirstName());
            Label lblsecond = new Label(newStudent.getSecondName());
            setStyle(lblfirst);
            setStyle(lblsecond);
            HBox Hnames = new HBox(10);
            Hnames.setPrefSize(300,30);
            Hnames.getChildren().addAll(lblfirst,lblsecond);
            Label lblID1 = new Label(newStudent.getId() + " " );
            Label lblemail1 = new Label(newStudent.getEmail());
            setStyle(lblID1);
            setStyle(lblemail1);
            VBox vinf1 = new VBox(5);
            vinf1.getChildren().addAll(lbluser1,Hnames,lblID1,lblemail1);
            Label lbluser2 = new Label("User Name:");
            Label lblname = new Label("Name: ");
            Label lblID2 = new Label("ID: ");
            Label lblemail2 = new Label("e-mail: ");
            lblname.setTextFill(Color.BLUEVIOLET);
            lbluser2.setTextFill(Color.BLUEVIOLET);
            lblID2.setTextFill(Color.BLUEVIOLET);
            lblemail2.setTextFill(Color.BLUEVIOLET);
            setStyle2(lbluser2);
            setStyle2(lblname);
            setStyle2(lblID2);
            setStyle2(lblemail2);
            VBox vinf2 = new VBox(5);
            vinf2.getChildren().addAll(lbluser2,lblname,lblID2,lblemail2);
            HBox hinf = new HBox(10);
            hinf.getChildren().addAll(vinf2,vinf1,vbuttons);
            Label lbledit = new Label("Edit your account information :");
            setStyle3(lbledit);
            //For e-mail address//
            Label lblemail3 = new Label("Enter your e-mail address :");
            setStyle2(lblemail3);
            TextField txtemail = new TextField();
            txtemail.setPromptText(newStudent.getEmail());
            txtemail.setStyle("-fx-prompt-text-fill: #565353"); //CSS
            txtemail.setPrefSize(365,30);
            HBox hemail = new HBox(txtemail);
            //For names//
            Label lblfirstname = new Label("First name :");
            Label lblsecondname = new Label("Second name :");
            setStyle2(lblfirstname);
            setStyle2(lblsecondname);
            TextField txtname1 = new TextField();
            TextField txtname2 = new TextField();
            setStyle(txtname1);
            setStyle(txtname2);
            VBox vfirst = new VBox(5);
            VBox vsecond = new VBox(5);
            vfirst.getChildren().addAll(lblfirstname,txtname1);
            vsecond.getChildren().addAll(lblsecondname,txtname2);
            HBox hnames = new HBox(10);
            hnames.getChildren().addAll(vfirst,vsecond);
            //for UserName//
            Label lblusername = new Label("UserName :");
            setStyle2(lblusername);
            TextField txtusername = new TextField();
            txtusername.setPromptText(newStudent.getUserName()+" ");
            txtusername.setStyle("-fx-prompt-text-fill: #565353"); //CSS
            setStyle(txtusername);
            //for password//
            Label lblwan = new Label("Set your password :");
            setStyle3(lblwan);
            Label lblcurrent = new Label("Current password :");
            Label lblnew = new Label    ("New      password :");
            setStyle2(lblcurrent);
            setStyle2(lblnew);
            HBox hcurrent = new HBox(lblcurrent,star());
            PasswordField passcurrent = new PasswordField();
            PasswordField passnew = new PasswordField();
            passcurrent.setPrefSize(200,30);
            passnew.setPrefSize(200,30);
            VBox v1 = new VBox(5);
            VBox v2 = new VBox(5);
            HBox hpass = new HBox(5);
            v1.getChildren().addAll(hcurrent,lblnew);
            v2.getChildren().addAll(passcurrent,passnew);
            hpass.getChildren().addAll(v1,v2);
            //Adding all information//
            vAll.getChildren().clear();
            vAll.getChildren().addAll(lblcurrentinfo,createSeparator(),hinf,lbledit,createSeparator(),hnames,
                    lblusername,txtusername,lblemail3,hemail,lblwan,createSeparator(),hpass);
            //actions of confirmation buttons//
            bsave.setOnAction(l->{                                               //save button//
                if (passcurrent.getText().equals(newStudent.getPassword())) {  //setting the basic info with the changes
                    if(!(txtname1.getText().isEmpty())){
                        lblfirst.setText(txtname1.getText());
                        newStudent.setFirstName(txtname1.getText());
                    }
                    if(!(txtname2.getText().isEmpty())){
                        lblsecond.setText(txtname2.getText());
                        newStudent.setSecondName(txtname2.getText());
                    }
                    if(!(txtemail.getText().isEmpty())){
                        lblemail1.setText(txtemail.getText());
                        newStudent.setEmail(txtemail.getText());
                        txtemail.setPromptText(newStudent.getEmail());
                    }
                    if(!(passnew.getText().isEmpty())){
                        newStudent.setPassword(passnew.getText());
                    }
                    if(!(txtusername.getText().isEmpty())){
                        lbluser1.setText(txtusername.getText());
                        name.setText(txtusername.getText());
                        newStudent.setUserName(txtusername.getText());
                        txtusername.setPromptText(newStudent.getUserName()+" ");
                    }
                    txtemail.clear();                 /* clearing the textboxes */
                    txtusername.clear();
                    txtname1.clear();
                    txtname2.clear();
                    passcurrent.clear();
                    passnew.clear();
                } else {
                    Alert wrongpass = new Alert(Alert.AlertType.ERROR);          //wrong entered password case//
                    wrongpass.setTitle("Warning");
                    wrongpass.setHeaderText("You may have entered a wrong password");
                    wrongpass.setContentText("Please go back and check it again");
                    wrongpass.show();
                    passcurrent.clear();
                }
            });
            bcancel.setOnAction(m->{       //cancel button//
                txtemail.clear();
                txtusername.clear();
                txtname1.clear();
                txtname2.clear();
                passcurrent.clear();
                passnew.clear();
            });
        });
        //**Subjects button Action**//
        subBtn.setOnAction( e-> {
            TableView<Subjects> table = new TableView<Subjects>();
            TableColumn<Subjects, String> subjects = new TableColumn<Subjects,String>("Subjects");
            TableColumn<Subjects, Button> data = new TableColumn<Subjects,Button>("Data");
            TableColumn ass = new TableColumn<Subjects,Button>("Assignments");
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            subjects.setCellValueFactory(new PropertyValueFactory<>("subject"));
            data.setCellValueFactory(new PropertyValueFactory<>("data"));
            ass.setCellValueFactory(new PropertyValueFactory<Subjects,Button>("ass"));
            table.getColumns().addAll(subjects,data,ass);
            table.setFixedCellSize(100);
            table.getItems().add(new Subjects("Mathematics",view().get(0), uploadFiles().get(0)));
            table.getItems().add(new Subjects("Humanities",view().get(1), uploadFiles().get(1)));
            table.getItems().add(new Subjects("Chemistry",view().get(2), uploadFiles().get(2)));
            table.getItems().add(new Subjects("Physics",view().get(3), uploadFiles().get(3)));
            table.getItems().add(new Subjects("Programming",view().get(4), uploadFiles().get(4)));
            table.setPrefSize(600,600);
            vAll.getChildren().clear();
            vAll.getChildren().addAll(table);
        });
        //**FeedBack button Action**//
        feedBtn.setOnAction(e->{
            Label l1 = new Label("*Rate the quality of this platform from 1-10,\nAnd write your opinion.");
            Label l2 = new Label("*Do you Find the information you seek?");
            Label l3 = new Label("*Do you have any problems in\n interacting with your teachers?");
            Label l4 = new Label("*What do you prefer,Online or Offline learing?");
            Label l5 = new Label("*Any suggestions to improve this platform?");
            setStyle3(l1);
            setStyle3(l2);
            setStyle3(l3);
            setStyle3(l4);
            setStyle3(l5);
            TextField t1 = new TextField();
            TextField t2 = new TextField();
            TextField t3 = new TextField();
            TextField t5 = new TextField();
            t1.setPrefSize(300,80);
            t2.setPrefSize(300,60);
            t3.setPrefSize(300,60);
            t5.setPrefSize(300,80);
            ToggleGroup toggleGroup = new ToggleGroup();
            RadioButton r4on = new RadioButton("online");
            RadioButton r4off = new RadioButton("Offline");
            r4on.setToggleGroup(toggleGroup);
            r4off.setToggleGroup(toggleGroup);
            r4on.setCursor(Cursor.HAND);
            r4off.setCursor(Cursor.HAND);
            HBox h4 = new HBox(10);
            h4.getChildren().addAll(r4on,r4off);
            Button send = new Button("send");
            send.setPrefSize(100,30);
            send.setTextFill(Color.BLUEVIOLET);
            send.setCursor(Cursor.HAND);
            send.setOnAction(s->{
                t1.clear();
                t2.clear();
                t3.clear();
                t5.clear();
                r4on.setSelected(false);
                r4off.setSelected(false);
            });
            vAll.getChildren().clear();
            vAll.getChildren().addAll(l1,t1,l2,t2,l3,t3,l4,h4,l5,t5,send);
        });
        h.getChildren().addAll(v, vAll);
        Scene studentScene = new Scene(h, 1000, 650);
        studentStage.setScene(studentScene);
        studentStage.show();
        // studentStage.setAlwaysOnTop(true);
    }
    /* :: End Of Student Dashboard :: */
    /* :: Teacher Dashboard :: */
    static VBox assinmentBtnPane()
    {
        Label assignmentLabel =new Label("   subject's Data ");
        assignmentLabel.setAlignment(Pos.TOP_LEFT);
        assignmentLabel.setFont(Font.font(20));
        assignmentLabel.setTextFill(Color.WHITESMOKE);
        assignmentLabel.setCursor(Cursor.TEXT);
        assignmentLabel.setMinWidth(150);
        assignmentLabel.setBackground(new Background(new BackgroundFill(Color.BLACK,
                new CornerRadii(50,50,50,50, false), null)));
        TableView <String> table = new TableView<>();
        TableColumn <String,String> column1 = new TableColumn<>("Chapters");
        TableColumn <String,String> column2 = new TableColumn<>("Assignments");
        table.getColumns().addAll(column1,column2);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Button upBtn = setbutton2("Upload");
        Button up2Btn = setbutton2("Upload");
        HBox hbuttons =new HBox(60);
        hbuttons.getChildren().addAll(upBtn,up2Btn);
        VBox vAss = new VBox(20);
        vAss.getChildren().addAll(assignmentLabel,table,hbuttons);
        return vAss;
    }
    static Pane attendanceBtnPane()
    {
        Label labelatt =new Label(" Student List Attendance  ");
        labelatt.setFont(Font.font(20));
        labelatt.setTextFill(Color.WHITESMOKE);
        labelatt.setCursor(Cursor.TEXT);
        labelatt.setMinWidth(200);
        labelatt.setAlignment(Pos.CENTER);
        labelatt.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(50, 10, 60, 10, false), null)));
        FlowPane  pane = new FlowPane();
        pane.setPadding(new Insets(50,50,50,50));
        Button Edit = new Button("Edit");
        Button save = new Button("Save");
        Edit.setMinSize(100, 30);
        save.setMinSize(100, 30);
        //Creating and initializing the checkboxes
        CheckBox ch1 = new CheckBox(student1.getName());
        ch1.setSelected( student1.getAttendance() );
        CheckBox ch2 = new CheckBox(student2.getName());
        ch2.setSelected(student2.getAttendance());
        CheckBox ch3 = new CheckBox(student3.getName());
        ch3.setSelected(student3.getAttendance());
        CheckBox ch4 = new CheckBox(student4.getName());
        ch4.setSelected(student4.getAttendance());
        CheckBox ch5 = new CheckBox(student5.getName());
        ch5.setSelected(student5.getAttendance());
        CheckBox ch6 = new CheckBox(student6.getName());
        ch6.setSelected(student6.getAttendance());
        CheckBox ch7 = new CheckBox(student7.getName());
        ch7.setSelected(student7.getAttendance());
        CheckBox ch8 = new CheckBox(student8.getName());
        ch8.setSelected(student8.getAttendance());
        CheckBox ch9 = new CheckBox(student9.getName());
        ch9.setSelected(student9.getAttendance());
        //Disable all checkboxes by default
        ch1.setDisable(true);
        ch2.setDisable(true);
        ch3.setDisable(true);
        ch4.setDisable(true);
        ch5.setDisable(true);
        ch6.setDisable(true);
        ch7.setDisable(true);
        ch8.setDisable(true);
        ch9.setDisable(true);
        //Styling The Buttons
        Edit.setCursor(Cursor.HAND);
        save.setCursor(Cursor.HAND);
        save.setBackground(new Background(new BackgroundFill(Color.ORANGE,
                new CornerRadii(50, 10, 60, 10, false), null)));
        Edit.setBackground(new Background(new BackgroundFill(Color.ORANGE,
                new CornerRadii(50, 10, 60, 10, false), null)));
        HBox btnsCont = new HBox(Edit,save);
        btnsCont.setSpacing(20);
        VBox container = new VBox(15);
        container.setPadding(new Insets(25,0,0,0));
        container.getChildren().addAll(ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,btnsCont);
        save.setOnAction(e -> {
            ch1.setDisable(true);
            ch2.setDisable(true);
            ch3.setDisable(true);
            ch4.setDisable(true);
            ch5.setDisable(true);
            ch6.setDisable(true);
            ch7.setDisable(true);
            ch8.setDisable(true);
            ch9.setDisable(true);
            student1.setAttendance(ch1.isSelected());
            student2.setAttendance(ch2.isSelected());
            student3.setAttendance(ch3.isSelected());
            student4.setAttendance(ch4.isSelected());
            student5.setAttendance(ch5.isSelected());
            student6.setAttendance(ch6.isSelected());
            student7.setAttendance(ch7.isSelected());
            student8.setAttendance(ch8.isSelected());
            student9.setAttendance(ch9.isSelected());
        });
        Edit.setOnAction(e -> {
            ch1.setDisable(false);
            ch2.setDisable(false);
            ch3.setDisable(false);
            ch4.setDisable(false);
            ch5.setDisable(false);
            ch6.setDisable(false);
            ch7.setDisable(false);
            ch8.setDisable(false);
            ch9.setDisable(false);
        });
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(labelatt,container);
        return pane;
    }
    static void teacherDashboard (Teacher teacher)
    {
        Stage teacherStage = new Stage();
        /* :: First We Create The Sidebar :: */
        /* :: User Name And Photo :: */
        userIcon.setFitWidth(50);
        userIcon.setFitHeight(50);
        Label name = new Label(teacher.getUserName());
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font(22));
        FlowPane userData = new FlowPane(userIcon,name);
        userData.setPadding(new Insets(0, 0, 10, 0));
        /* :: Account Button :: */
        FlowPane pane = new FlowPane();
        Label nameLabel = new Label("Name");
        TextField nameTxt = new TextField(teacher.getName());
        nameTxt.setDisable(true);
        Label usernameLabel = new Label("Username   ");
        TextField usernameTxt = new TextField(teacher.getUserName());
        usernameTxt.setDisable(true);
        HBox hBox1 = new HBox(nameLabel, nameTxt, usernameLabel, usernameTxt);
        hBox1.setSpacing(41);
        Label addressLabel = new Label("Address");
        TextField addressTxt = new TextField(teacher.getAddress());
        addressTxt.setDisable(true);
        Label subLabel = new Label("     Subject           ");
        TextField subTxt = new TextField(teacher.getSubject());
        subTxt.setDisable(true);
        Label ageLabel = new Label("Age              ");
        TextField ageTxt = new TextField(teacher.getAge()+" ");
        ageTxt.setDisable(true);
        Label NatLabel = new Label("           Nationality          ");
        TextField nationalityTxt = new TextField(teacher.getNationality());
        nationalityTxt.setDisable(true);
        Button saveBtn = new Button("Save Changes");
        saveBtn.setOnAction(e -> {
            teacher.setUserName(usernameTxt.getText());
            name.setText(usernameTxt.getText());
            usernameTxt.setDisable(true);
            teacher.setName(nameTxt.getText());
            nameTxt.setDisable(true);
            teacher.setSubject(subTxt.getText());
            subTxt.setDisable(true);
            teacher.setAddress(addressTxt.getText());
            addressTxt.setDisable(true);
            teacher.setNationality(nationalityTxt.getText());
            nationalityTxt.setDisable(true);
            try {                                               //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                teacher.setAge(Double.parseDouble(ageTxt.getText()));
                ageTxt.setDisable(true);
            }catch (NumberFormatException exception){
                Alert alertm = new Alert(Alert.AlertType.ERROR);
                alertm.setHeaderText("WRONG ENTERED INPUT");
                alertm.setContentText("You have to enter your age in digits");
                alertm.show();
            }
        });
        Button editBtn = new Button("Edit Data");
        editBtn.setOnAction(e -> {
            usernameTxt.setDisable(false);
            nameTxt.setDisable(false);
            subTxt.setDisable(false);
            addressTxt.setDisable(false);
            ageTxt.setDisable(false);
            nationalityTxt.setDisable(false);
        });
        saveBtn.setCursor(Cursor.HAND);
        editBtn.setCursor(Cursor.HAND);
        saveBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE,
                new CornerRadii(50, 50, 50, 50, false), null)));
        editBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE,
                new CornerRadii(50, 50, 50, 50, false), null)));
        HBox hbx4 = new HBox(ageLabel, ageTxt, NatLabel, nationalityTxt);
        HBox hbx2 = new HBox(addressLabel, addressTxt, subLabel, subTxt);
        hbx2.setSpacing(25);
        HBox hbx3 = new HBox(20);
        pane.setHgap(20);
        pane.setVgap(20);
        hbx3.setAlignment(Pos.CENTER_RIGHT);
        hbx3.getChildren().addAll(editBtn, saveBtn);
        pane.getChildren().addAll(hBox1, hbx2, hbx4,hbx3);
        pane.setPadding(new Insets(250, 0, 0, 50));
        Button accountBtn = createSideBarButtons();
        accountIcon.setFitHeight(20);
        accountIcon.setFitWidth(20);
        accountBtn.setGraphic(accountIcon);
        accountBtn.setText(" Account");
        FlowPane accBtn_cont = new FlowPane(accountBtn);
        accountBtn.setOnAction(e -> {
            hBox2.getChildren().clear();
            hBox2.getChildren().add(pane);
        });
        /* :: Data Button :: */
        Button assignmentBtn = createSideBarButtons();
        assignmentBtn.setGraphic(subjectsIcon);
        assignmentBtn.setText(" Data");
        FlowPane assignmentBtn_cont = new FlowPane(assignmentBtn);
        assignmentBtn.setOnAction(e -> {
            hBox2.getChildren().clear();
            hBox2.getChildren().add(assinmentBtnPane());
        });
        /* :: Attendance Button :: */

        Button subBtn = createSideBarButtons();
        subBtn.setGraphic(attendanceIcon);
        subBtn.setText(" Attendance");
        FlowPane subBtn_cont = new FlowPane(subBtn);
        subBtn.setOnAction(e -> {
            hBox2.getChildren().clear();
            hBox2.getChildren().add(attendanceBtnPane());
        });
        /* :: University Platform Button :: */
        Button platform = createSideBarButtons();
        platform.setGraphic(platformIcon);
        platform.setText(" University Platform");
        platform.setOnAction(event -> {
            try {
                String url = "http://admineng.eps.zu.edu.eg/Views/StudentViews/ESubjectsExams";
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        FlowPane platform_cont = new FlowPane( platform );
        /* :: Logout Button :: */
        Button logOutBtn = createSideBarButtons();
        logOutBtn.setGraphic(logOutImg);
        logOutBtn.setText("Log Out ");
        FlowPane logout_cont = new FlowPane(logOutBtn);
        logOutBtn.setOnAction(e-> {
            vAll.getChildren().clear();
            teacherStage.close();
            teacher.clearData();
            loginPage();
        });
        VBox v = new VBox();
        v.setMaxWidth(250);
        v.setMinHeight(580);
        //  Creating And Styling The Sidebar background ::
        BackgroundFill sidebar_backgroundFill = new BackgroundFill(Color.web("#23252b"),
                new CornerRadii(0, 50, 50, 0, false), null); // Setting The Color And the Curves
        Background sidebar_background = new Background(sidebar_backgroundFill);
        v.setBackground(sidebar_background);
        v.setAlignment(Pos.TOP_CENTER);
        v.setPadding(new Insets(50, 0, 10, 10));
        v.setSpacing(20);
        v.getChildren().addAll(userData, accBtn_cont, assignmentBtn_cont, subBtn_cont, platform_cont,logout_cont); //Adding All The Elements to The VBox
        /* :: End Of Sidebar :: */
        teacherStage.setTitle("Teacher");
        HBox hBox = new HBox(20); //Base Container
        hBox.getChildren().addAll(v, hBox2);
        Scene scene = new Scene(hBox, 1000, 600);
        teacherStage.setScene(scene);
        teacherStage.show();
    }
    /* :: End Of Teacher Dashboard :: */
    /* :: Administrator Dashboard :: */
    static void administratorDashboard() {
        Stage adminStage = new Stage();
        /* :: User Name And Photo :: */
        Label name = new Label();
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font(22));
        FlowPane userData = new FlowPane(name);
        userData.setPadding(new Insets(0, 0, 10, 0));
        /* :: Teachers Data Button :: */
        Button tdataBtn = createSideBarButtons();
        tdataBtn.setText(" Teachers Data");
        FlowPane tdataBtn_cont = new FlowPane(tdataBtn);
        tdataBtn.setOnAction(e -> {
            hBoxx.getChildren().clear();
            hBoxx.getChildren().add(tdataBtnPane());
        });
        /* :: students data Button :: */
        Button subBtn = createSideBarButtons();
        subBtn.setText(" Students Data");
        FlowPane subBtn_cont = new FlowPane(subBtn);
        subBtn.setOnAction(e -> {
            hBoxx.getChildren().clear();
            hBoxx.getChildren().add(studataBtnPane());
        });
        /* :: University Platform Button :: */
        Button platform = createSideBarButtons();
        platform.setText(" University Platform");
        platform.setOnAction(event -> {
            try {
                String url = "http://admineng.eps.zu.edu.eg/Views/StudentViews/ESubjectsExams";
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        FlowPane platform_cont = new FlowPane(platform);
        VBox v = new VBox();
        v.setMaxWidth(250);
        v.setMinHeight(580);
        /* :: Logout Button :: */
        Button logOutBtn = createSideBarButtons();
        logOutBtn.setGraphic(new ImageView(new Image("src\\images\\logout.png")));
        logOutBtn.setText("Log Out ");
        FlowPane logout_cont = new FlowPane(logOutBtn);
        logOutBtn.setOnAction(e -> {
            vAll.getChildren().clear();
            adminStage.close();
            loginPage();
        });
        //  Creating And Styling The Sidebar background ::
        BackgroundFill sidebar_backgroundFill = new BackgroundFill(Color.web("#23252b"),
                new CornerRadii(0, 50, 50, 0, false), null); // Setting The Color And the Curves
        Background sidebar_background = new Background(sidebar_backgroundFill);
        v.setBackground(sidebar_background);
        v.setAlignment(Pos.TOP_CENTER);
        v.setPadding(new Insets(50, 0, 10, 10));
        v.setSpacing(20);
        v.getChildren().addAll(userData, tdataBtn_cont, subBtn_cont, platform_cont, logout_cont); //Adding All The Elements to The VBox
        adminStage.setTitle("Administrator");
        hBox.getChildren().addAll(v, hBoxx);
        Scene scene = new Scene(hBox, 1000, 600);
        adminStage.setScene(scene);
        adminStage.show();
    }
    static Pane tdataBtnPane ()
    {
        FlowPane pane = new FlowPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        Label labacc = new Label("  Teacher NO.1  ");
        Label labacc1 = new Label("  Teacher NO.2  ");
        labacc1.setTranslateY(180);
        labacc.setFont(Font.font(15));
        labacc.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30, 30, 30, 30, false), null)));
        labacc.setTextFill(Color.WHITESMOKE);
        labacc.setCursor(Cursor.TEXT);
        labacc.setMinWidth(50);
        labacc1.setFont(Font.font(15));
        labacc1.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30, 30, 30, 30, false), null)));
        labacc1.setTextFill(Color.WHITESMOKE);
        labacc1.setCursor(Cursor.TEXT);
        labacc1.setMinWidth(50);
        VBox labaccBox = new VBox();
        labaccBox.setAlignment(Pos.TOP_CENTER);
        labaccBox.getChildren().addAll(labacc, labacc1);
        Label nameLabel = new Label("Name");
        TextField nameTxt = new TextField("  Mohamed naguib   ");
        Label nameLabel1 = new Label("Name");
        TextField nameTxt1 = new TextField("  Khaled Ahmed   ");
        nameTxt.setDisable(true);
        nameLabel.setMinWidth(50);
        nameLabel.setMinWidth(50);
        nameTxt.setMinWidth(100);
        nameTxt1.setDisable(true);
        nameLabel1.setMinWidth(50);
        nameLabel1.setMinWidth(50);
        VBox nameBox = new VBox();
        nameBox.setSpacing(20);
        nameBox.getChildren().addAll(nameLabel, nameTxt);
        Label subLabel = new Label("     Subject         ");
        TextField subTxt = new TextField("   Maths   ");
        subTxt.setDisable(true);
        Label ageLabel = new Label("  Age  ");
        TextField ageTxt = new TextField(" 34 ");
        ageTxt.setDisable(true);
        Button svbtn = new Button("Save Changes");
        svbtn.setOnAction(e -> {
        });
        Button edtbtn = new Button("Edit");
        edtbtn.setOnAction(e -> {
        });
        svbtn.setCursor(Cursor.HAND);
        edtbtn.setCursor(Cursor.HAND);
        svbtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(50, 50, 50, 50, false), null)));
        edtbtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(50, 50, 50, 50, false), null)));
        VBox vbx2 = new VBox(subLabel, subTxt);
        vbx2.setSpacing(20);
        VBox vbx4 = new VBox(ageLabel, ageTxt);
        vbx4.setSpacing(20);
        HBox hbx3 = new HBox(20);
        hbx3.setTranslateY(500);
        hbx3.setTranslateX(200);
        hbx3.getChildren().addAll(edtbtn, svbtn);
        Line line = new Line(60, 1000, 400, 1000);
        line.setTranslateY(135);
        line.setTranslateX(80);
        HBox h2 = new HBox();
        VBox v1 = new VBox(20);
        VBox v2 = new VBox(20);
        VBox v3 = new VBox(20);
        v1.setMinWidth(100);
        v2.setMinWidth(100);
        v3.setMinWidth(100);
        Label subLabel1 = new Label("     Subject     ");
        TextField subTxt1 = new TextField(" Humanities ");
        Label ageLabel1 = new Label("      Age      ");
        TextField ageTxt1 = new TextField(" 42 ");
        subTxt1.setDisable(true);
        ageLabel1.setMinWidth(50);
        ageLabel1.setMinWidth(50);
        ageTxt1.setDisable(true);
        subLabel1.setMinWidth(50);
        subLabel1.setMinWidth(50);
        v1.getChildren().addAll(nameLabel1, nameTxt1);
        v2.getChildren().addAll(subLabel1, subTxt1);
        v3.getChildren().addAll(ageLabel1, ageTxt1);
        svbtn.setOnAction(e -> {
            nameTxt1.setDisable(true);
            subTxt1.setDisable(true);
            ageTxt1.setDisable(true);
            nameTxt.setDisable(true);
            subTxt.setDisable(true);
            ageTxt.setDisable(true);
        });
        edtbtn.setOnAction(e -> {
            nameTxt1.setDisable(false);
            subTxt1.setDisable(false);
            ageTxt1.setDisable(false);
            nameTxt.setDisable(false);
            subTxt.setDisable(false);
            ageTxt.setDisable(false);
        });
        h2.getChildren().addAll(v1, v2, v3);
        h2.setTranslateY(100);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(250, 300, 300, 150));
        pane.getChildren().addAll(hbx3);
        HBox h = new HBox(20);
        h.getChildren().addAll(nameBox, vbx2, vbx4);
        // create the FlowPane and add the main VBox and labaccBox
        pane.getChildren().addAll(labaccBox, line, h, h2);
        pane.setHgap(10);
        pane.setVgap(10);
        return pane;
    }
    static Pane studataBtnPane ()
    {
        FlowPane pane = new FlowPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        Label labacc = new Label("  Student NO.1  ");
        Label labacc1 = new Label("  Student NO.2  ");
        labacc1.setTranslateY(180);
        labacc.setFont(Font.font(15));
        labacc.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30, 30, 30, 30, false), null)));
        labacc.setTextFill(Color.WHITESMOKE);
        labacc.setCursor(Cursor.TEXT);
        labacc.setMinWidth(50);
        labacc1.setFont(Font.font(15));
        labacc1.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30, 30, 30, 30, false), null)));
        labacc1.setTextFill(Color.WHITESMOKE);
        labacc1.setCursor(Cursor.TEXT);
        labacc1.setMinWidth(50);
        VBox labaccBox = new VBox();
        labaccBox.setAlignment(Pos.TOP_CENTER);
        labaccBox.getChildren().addAll(labacc, labacc1);
        Label nameLabel = new Label("Name");
        TextField nameTxt = new TextField("  Mohamed Hamdi   ");
        Label nameLabel1 = new Label("Name");
        TextField nameTxt1 = new TextField("  Ahmed Emad   ");
        nameTxt.setDisable(true);
        nameLabel.setMinWidth(50);
        nameLabel.setMinWidth(50);
        nameTxt.setMinWidth(100);
        nameTxt1.setDisable(true);
        nameLabel1.setMinWidth(50);
        nameLabel1.setMinWidth(50);
        VBox nameBox = new VBox();
        nameBox.setSpacing(20);
        nameBox.getChildren().addAll(nameLabel, nameTxt);
        Label subLabel = new Label("     GPA         ");
        TextField subTxt = new TextField("  1.8   ");
        subTxt.setDisable(true);
        Label ageLabel = new Label("  ID  ");
        TextField ageTxt = new TextField(" 12345678900 ");
        ageTxt.setDisable(true);
        Button svbtn = new Button("Save Changes");
        Button edtbtn = new Button("Edit");
        svbtn.setCursor(Cursor.HAND);
        edtbtn.setCursor(Cursor.HAND);
        svbtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(50, 50, 50, 50, false), null)));
        edtbtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(50, 50, 50, 50, false), null)));
        VBox vbx2 = new VBox(subLabel, subTxt);
        vbx2.setSpacing(20);
        VBox vbx4 = new VBox(ageLabel, ageTxt);
        vbx4.setSpacing(20);
        HBox hbx3 = new HBox(20);
        hbx3.setTranslateY(500);
        hbx3.setTranslateX(200);
        hbx3.getChildren().addAll(edtbtn, svbtn);
        Line line = new Line(60, 1000, 400, 1000);
        line.setTranslateY(135);
        line.setTranslateX(80);
        HBox h2 = new HBox();
        VBox v1 = new VBox(20);
        VBox v2 = new VBox(20);
        VBox v3 = new VBox(20);
        v1.setMinWidth(100);
        v2.setMinWidth(100);
        v3.setMinWidth(100);
        Label subLabel1 = new Label("     GPA     ");
        TextField subTxt1 = new TextField(" 1.3 ");
        Label ageLabel1 = new Label("      ID      ");
        TextField ageTxt1 = new TextField(" 12345678901 ");
        subTxt1.setDisable(true);
        ageLabel1.setMinWidth(50);
        ageLabel1.setMinWidth(50);
        ageTxt1.setDisable(true);
        subLabel1.setMinWidth(50);
        subLabel1.setMinWidth(50);
        v1.getChildren().addAll(nameLabel1, nameTxt1);
        v2.getChildren().addAll(subLabel1, subTxt1);
        v3.getChildren().addAll(ageLabel1, ageTxt1);
        svbtn.setOnAction(e -> {
            nameTxt1.setDisable(true);
            subTxt1.setDisable(true);
            ageTxt1.setDisable(true);
            nameTxt.setDisable(true);
            subTxt.setDisable(true);
            ageTxt.setDisable(true);
        });
        edtbtn.setOnAction(e -> {
            nameTxt1.setDisable(false);
            subTxt1.setDisable(false);
            ageTxt1.setDisable(false);
            nameTxt.setDisable(false);
            subTxt.setDisable(false);
            ageTxt.setDisable(false);
        });
        h2.getChildren().addAll(v1, v2, v3);
        h2.setTranslateY(100);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(250, 300, 300, 150));
        pane.getChildren().addAll(hbx3);
        HBox h = new HBox(20);
        h.getChildren().addAll(nameBox, vbx2, vbx4);
        // create the FlowPane and add the main VBox and labaccBox
        pane.getChildren().addAll(labaccBox, line, h, h2);
        pane.setHgap(10);
        pane.setVgap(10);
        return pane;
    }
    /* :: End Of Administrator Dashboard :: */
    /* :: Fun Creates the SignUp Button Action :: */

    /* :: End Of Register Action :: */
    /* :: Frequently Used Methods :: */
    public static Separator createSeparator() //Fun Creates Horizontal Separator Line
    {
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);
        separator.setMaxWidth(250);
        separator.setPadding(new Insets(5,0,5,0));
        return separator;
    }
    static void setMaxWidth_minHeight(TextField textField) // Frequently Used Fun sets the width,height
    {
        textField.setMaxWidth(250);
        textField.setMinHeight(30);
    }
    //Overload
    static void setMaxWidth_minHeight(PasswordField passwordField) // Frequently Used Fun sets the width,height
    {
        passwordField.setMaxWidth(250);
        passwordField.setMinHeight(30);
    }
    //Overload
    static void setMaxWidth_minHeight(Label label) // Frequently Used Fun sets the width,height
    {
        label.setMaxWidth(400);
        label.setMinHeight(30);
    }
    //Set Style of the userName and Password Fields :
    static void setStyle (TextField textField)
    {
        textField.setStyle("-fx-prompt-text-fill:#565353;-fx-font-size:14;");   //CSS
        setMaxWidth_minHeight(textField);
    }
    // Functions to make different sizes of labels //
    static void setStyle (Label label)    //label with fontsize 16
    {
        label.setFont(Font.font(16));
        setMaxWidth_minHeight(label);
    }
    static void setStyle2 (Label label)   //label with fontsize 18
    {
        label.setFont(Font.font(18));
        setMaxWidth_minHeight(label);
    }
    static void setStyle3 (Label label)  //label with fontsize 22
    {
        label.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.ITALIC,22));
        label.setTextFill(Color.BLUEVIOLET);
        label.setMaxSize(500,400);
    }

    static Label star ()    //makes a red star//
    {
        Label star = new Label("*");
        star.setTextFill(Color.RED);
        star.setMinWidth(5);
        star.setMinHeight(30);
        return star;
    }
    //A function returns a button used to upload files//
    public static ArrayList<Button> uploadFiles()
    {
        ArrayList<Button> button= new ArrayList<>();
        for (int i=0;i<=4;i++){
            Button b = setbutton("Upload");
            b.setOnAction(e->{
                FileChooser file = new FileChooser();
                file.setTitle("upload file");
                Stage stage= new Stage();
                File file1=file.showOpenDialog(stage);
            });
            button.add(b);
        }
        return button;
    }
    //A function returns a button used to open a table//
    public static ArrayList<Button> view (){
        ArrayList<Button> button = new ArrayList<>();
        for (int i=0;i<=4;i++){
            Button b= setbutton("View");
            b.setOnAction(e->{
                TableView<Chapters> table = new TableView<Chapters>(); // "Chapters" is a class
                TableColumn<Chapters, String> chapter = new TableColumn<Chapters,String>("Chapters");
                chapter.setCellValueFactory(new PropertyValueFactory<>("chapters"));
                TableColumn<Chapters, Button> view = new TableColumn<Chapters,Button>("View Data");
                view.setCellValueFactory(new PropertyValueFactory<>("button"));
                table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                table.setPrefSize(600,600);
                table.setFixedCellSize(120);
                table.getColumns().addAll(chapter,view);
                table.getItems().addAll(new Chapters("Chapter 1",open().get(0)));
                table.getItems().addAll(new Chapters("Chapter 2",open().get(1)));
                table.getItems().addAll(new Chapters("Chapter 3",open().get(2)));
                table.getItems().addAll(new Chapters("Chapter 4",open().get(3)));
                vAll.getChildren().clear();
                vAll.getChildren().addAll(table);
            });
            button.add(b);
        }
        return button;
    }
    //A method returns button that open files//
    public static ArrayList<Button> open (){
        ArrayList<Button> button= new ArrayList<>();
        for (int i=0;i<=3;i++){
            Button b = setbutton("Open");
            b.setOnAction(e->{
                try {
                    Scanner input = new Scanner(new File("src\\data.txt"));
                    System.out.println(input.nextLine());
                } catch (FileNotFoundException ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("File not found");
                    alert.show();
                }
            });
            button.add(b);
        }
        return button;
    }
    //Methods setting the style of Buttons//
    public static Button setbutton (String word)
    {
        Button b = new Button(word);
        b.setTextFill(Color.BLUEVIOLET);
        b.setPrefSize(100,30);
        b.setCursor(Cursor.HAND);
        return b;
    }
    public static Button setbutton2(String word){
        Button b = new Button(word);
        b.setCursor(Cursor.HAND);
        b.setBackground(new Background(new BackgroundFill(Color.ORANGE,
                new CornerRadii(50, 50, 50, 50, false), null)));
        b.setOnAction(e -> {
            FileChooser fileChooser=new FileChooser();
            fileChooser.setTitle("Open File");
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);
        });
        return b;
    }
    static Button createSideBarButtons()  // fun() creates and styles the sidebar buttons
    {
        Button button = new Button();
        button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
        button.setFont(Font.font(16));
        button.setTextFill(Color.WHITE);
        button.setCursor(Cursor.HAND);
        button.setMinWidth(230);
        button.setAlignment(Pos.BASELINE_LEFT);
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-border-width:0px 0px 0px 2px;-fx-border-color: red;"); //CSS
            button.setBackground(new Background(new BackgroundFill(Color.web("#404040"),null,null)));
            button.setFont(Font.font("Arial",FontPosture.ITALIC,18));
            button.setTextFill(Color.WHITE);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(""); //css
            button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
            button.setFont(Font.font(16));

        });
        return button;
    }
    static Button createSideBarButtons(String text)  // fun() creates and styles the sidebar buttons
    {
        Button button = new Button(text);
        button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
        button.setFont(Font.font(16));
        button.setTextFill(Color.WHITE);
        button.setCursor(Cursor.HAND);
        button.setMinWidth(230);
        button.setAlignment(Pos.BASELINE_LEFT);
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-border-width:0px 0px 0px 2px;-fx-border-color: red;"); //CSS
            button.setBackground(new Background(new BackgroundFill(Color.web("#404040"),null,null)));
            button.setFont(Font.font("Arial",FontPosture.ITALIC,18));
            button.setTextFill(Color.WHITE);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(""); //css
            button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
            button.setFont(Font.font(16));

        });
        return button;
    }
    static TextField createUsernameField ()         //Function Creates userName Field
    {
        TextField user = new TextField();
        user.setPromptText("Enter your Username");
        user.setStyle("-fx-prompt-text-fill:#565353;-fx-font-size:14;");   //CSS
        setMaxWidth_minHeight(user);
        return user;
    }
//
    static PasswordField createPasswordField()      //Function Creates PasswordField
    {
        PasswordField pass = new PasswordField();
        pass.setPromptText("Enter your Password");
        pass.setStyle("-fx-prompt-text-fill: #565353;-fx-font-size:14;");
        setMaxWidth_minHeight(pass);
        return pass;
    }
    static boolean areEmpty (TextField t1 , TextField t2 ,
                             TextField t3,TextField t4 ,
                             TextField t5 , TextField t6 )  //Function Creates PasswordField
    {
        return t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() ||
                t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty();
    }
    /* :: End Of Frequently Used Methods :: */
    @Override
    public void start(Stage loginStage)
    {
        loginPage();
    }
    public static void main(String[] args) {
        launch();
    }
}