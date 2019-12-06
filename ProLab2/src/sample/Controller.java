package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.IfNode;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    Pokemon Pokes = new Pokemon();
    public Pokemon.Pikachu Pikachu = Pokes.new Pikachu();
    public Pokemon.Bulbasaur Bulbasaur = Pokes.new Bulbasaur();
    public Pokemon.Zubat Zubat = Pokes.new Zubat();
    public Pokemon.Charmander Charmander = Pokes.new Charmander();
    public Pokemon.Psyduck Psyduck = Pokes.new Psyduck();
    public Pokemon.Snorlax Snorlax = Pokes.new Snorlax();
    public Pokemon.Squirtle Squirtle = Pokes.new Squirtle();
    public Pokemon.Butterfree Butterfree = Pokes.new Butterfree();
    public Pokemon.Jigglypuff Jigglypuff = Pokes.new Jigglypuff();
    public Pokemon.Meowth Meowth = Pokes.new Meowth();


    Oyuncu oyuncuClass = new Oyuncu();
    Oyuncu insanOyuncu = oyuncuClass.new InsanOyuncusu();
    Oyuncu bilgisayarOyuncu = oyuncuClass.new BilgisayarOyuncusu();

    @FXML
    private Label cardsLeft;

    @FXML
    private Label secondPlayer;

    @FXML
    private Label firstPlayer;

    @FXML
    private CheckBox aiCheckBox;

    @FXML
    private CheckBox userCheckBox;

    @FXML
    private Pane menuBtn;

    @FXML
    private Label AIscore;

    @FXML
    private Label playerScore;

    @FXML
    private Pane settingsbar;

    @FXML
    private Pane StartPane;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton RestartButton;

    @FXML
    private ImageView winScreen;

    @FXML
    private ImageView loseScreen;

    @FXML
    private ImageView ai1Wins;

    @FXML
    private ImageView drawScreen;

    @FXML
    private ImageView ai2Wins;

    @FXML
    private ImageView BulbasaurImg;

    @FXML
    private ImageView ButterfreeImg;

    @FXML
    private ImageView CharmanderImg;

    @FXML
    private ImageView JigglypuffImg;

    @FXML
    private ImageView MeowthImg;

    @FXML
    private ImageView PikachuImg;

    @FXML
    private ImageView PsyduckImg;

    @FXML
    private ImageView SnorlaxImg;

    @FXML
    private ImageView SquirtleImg;

    @FXML
    private ImageView ZubatImg;

    @FXML
    private JFXButton Shuffle;

    @FXML
    private JFXButton nextTour;


    ArrayList<Object> pokemons= new ArrayList<>();
    ArrayList<Object> player = new ArrayList<>();
    ArrayList<Object> AI = new ArrayList<>();
    Object o = new Object();
    Object o2 = new Object();
    Object objectToDelete = new Object();
    Object objectToDelete2 = new Object();

    int AP = 0;
    int AP2 =0;
    boolean isSlot1Full = false;
    boolean isSlot2Full = false;
    boolean isSlot3Full = false;

    boolean isAISlot1Full = false;
    boolean isAISlot2Full = false;
    boolean isAISlot3Full = false;

    @FXML
    void shuffleClick(MouseEvent event) {
        Shuffle.setDisable(true);
        cardsLeft.setText("4");

        pokemons.add(Pikachu);
        pokemons.add(Squirtle);
        pokemons.add(Bulbasaur);
        pokemons.add(Psyduck);
        pokemons.add(Zubat);
        pokemons.add(Snorlax);
        pokemons.add(Meowth);
        pokemons.add(Butterfree);
        pokemons.add(Charmander);
        pokemons.add(Jigglypuff);

        Random random = new Random();
        //ARRAYLIST PLAYER

        player.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(player.get(0)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }
        player.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(player.get(1)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }
        player.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(player.get(2)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }
        //ARRAYLIST AI
        AI.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(AI.get(0)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }
        AI.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(AI.get(1)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }
        AI.add(pokemons.get(random.nextInt(pokemons.size())));
        for (int j=0; j<pokemons.size();j++)
        {
            if(AI.get(2)== pokemons.get(j))
            {
                pokemons.remove(j);
            }
        }

        for (int i=0; i<3;i++)
        {
            //PLAYER CARD SET
            if(player.get(i)==Pikachu)
            {

                if(isSlot1Full==false)
                {
                    PikachuImg.setLayoutX(110);
                    PikachuImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    PikachuImg.setLayoutX(236);
                    PikachuImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    PikachuImg.setLayoutX(363);
                    PikachuImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Bulbasaur)
            {
                if(isSlot1Full==false)
                {
                    BulbasaurImg.setLayoutX(110);
                    BulbasaurImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    BulbasaurImg.setLayoutX(236);
                    BulbasaurImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    BulbasaurImg.setLayoutX(363);
                    BulbasaurImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Psyduck)
            {
                if(isSlot1Full==false)
                {
                    PsyduckImg.setLayoutX(110);
                    PsyduckImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    PsyduckImg.setLayoutX(236);
                    PsyduckImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    PsyduckImg.setLayoutX(363);
                    PsyduckImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Snorlax)
            {
                if(isSlot1Full==false)
                {
                    SnorlaxImg.setLayoutX(110);
                    SnorlaxImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    SnorlaxImg.setLayoutX(236);
                    SnorlaxImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    SnorlaxImg.setLayoutX(363);
                    SnorlaxImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Butterfree)
            {
                if(isSlot1Full==false)
                {
                    ButterfreeImg.setLayoutX(110);
                    ButterfreeImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    ButterfreeImg.setLayoutX(236);
                    ButterfreeImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    ButterfreeImg.setLayoutX(363);
                    ButterfreeImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Squirtle)
            {
                if(isSlot1Full==false)
                {
                    SquirtleImg.setLayoutX(110);
                    SquirtleImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    SquirtleImg.setLayoutX(236);
                    SquirtleImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    SquirtleImg.setLayoutX(363);
                    SquirtleImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Zubat)
            {
                if(isSlot1Full==false)
                {
                    ZubatImg.setLayoutX(110);
                    ZubatImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    ZubatImg.setLayoutX(236);
                    ZubatImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    ZubatImg.setLayoutX(363);
                    ZubatImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Charmander)
            {
                if(isSlot1Full==false)
                {
                    CharmanderImg.setLayoutX(110);
                    CharmanderImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    CharmanderImg.setLayoutX(236);
                    CharmanderImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    CharmanderImg.setLayoutX(363);
                    CharmanderImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Meowth)
            {
                if(isSlot1Full==false)
                {
                    MeowthImg.setLayoutX(110);
                    MeowthImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    MeowthImg.setLayoutX(236);
                    MeowthImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    MeowthImg.setLayoutX(363);
                    MeowthImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }
            if(player.get(i)==Jigglypuff)
            {
                if(isSlot1Full==false)
                {
                    JigglypuffImg.setLayoutX(110);
                    JigglypuffImg.setLayoutY(452);
                    isSlot1Full=true;
                }
                else if(isSlot2Full==false && isSlot1Full==true)
                {
                    JigglypuffImg.setLayoutX(236);
                    JigglypuffImg.setLayoutY(452);
                    isSlot2Full=true;
                }
                else if(isSlot3Full==false && isSlot2Full==true)
                {
                    JigglypuffImg.setLayoutX(363);
                    JigglypuffImg.setLayoutY(452);
                    isSlot3Full=true;
                }
            }

            //AI CARD SET

            if(AI.get(i)==Pikachu)
            {

                if(isAISlot1Full==false)
                {
                    PikachuImg.setLayoutX(110);
                    PikachuImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    PikachuImg.setLayoutX(236);
                    PikachuImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    PikachuImg.setLayoutX(363);
                    PikachuImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
            }
            if(AI.get(i)==Bulbasaur)
            {
                if(isAISlot1Full==false)
                {
                    BulbasaurImg.setLayoutX(110);
                    BulbasaurImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    BulbasaurImg.setLayoutX(236);
                    BulbasaurImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    BulbasaurImg.setLayoutX(363);
                    BulbasaurImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Psyduck)
            {
                if(isAISlot1Full==false)
                {
                    PsyduckImg.setLayoutX(110);
                    PsyduckImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    PsyduckImg.setLayoutX(236);
                    PsyduckImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    PsyduckImg.setLayoutX(363);
                    PsyduckImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Snorlax)
            {
                if(isAISlot1Full==false)
                {
                    SnorlaxImg.setLayoutX(110);
                    SnorlaxImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    SnorlaxImg.setLayoutX(236);
                    SnorlaxImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    SnorlaxImg.setLayoutX(363);
                    SnorlaxImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Butterfree)
            {
                if(isAISlot1Full==false)
                {
                    ButterfreeImg.setLayoutX(110);
                    ButterfreeImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    ButterfreeImg.setLayoutX(236);
                    ButterfreeImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    ButterfreeImg.setLayoutX(363);
                    ButterfreeImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Squirtle)
            {
                if(isAISlot1Full==false)
                {
                    SquirtleImg.setLayoutX(110);
                    SquirtleImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    SquirtleImg.setLayoutX(236);
                    SquirtleImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    SquirtleImg.setLayoutX(363);
                    SquirtleImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Zubat)
            {
                if(isAISlot1Full==false)
                {
                    ZubatImg.setLayoutX(110);
                    ZubatImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    ZubatImg.setLayoutX(236);
                    ZubatImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    ZubatImg.setLayoutX(363);
                    ZubatImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Charmander)
            {
                if(isAISlot1Full==false)
                {
                    CharmanderImg.setLayoutX(110);
                    CharmanderImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    CharmanderImg.setLayoutX(236);
                    CharmanderImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    CharmanderImg.setLayoutX(363);
                    CharmanderImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Meowth)
            {
                if(isAISlot1Full==false)
                {
                    MeowthImg.setLayoutX(110);
                    MeowthImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    MeowthImg.setLayoutX(236);
                    MeowthImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    MeowthImg.setLayoutX(363);
                    MeowthImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
            if(AI.get(i)==Jigglypuff)
            {
                if(isAISlot1Full==false)
                {
                    JigglypuffImg.setLayoutX(110);
                    JigglypuffImg.setLayoutY(0);
                    isAISlot1Full=true;
                }
                else if(isAISlot2Full==false && isAISlot1Full == true)
                {
                    JigglypuffImg.setLayoutX(236);
                    JigglypuffImg.setLayoutY(0);
                    isAISlot2Full=true;
                }
                else if(isAISlot3Full==false && isAISlot2Full==true)
                {
                    JigglypuffImg.setLayoutX(363);
                    JigglypuffImg.setLayoutY(0);
                    isAISlot3Full=true;
                }
            }
        }


    }
    boolean isSecondTour = false;

    void subShuffle()
    {

        if(isSecondTour)
        {
            for (int i=0; i<3;i++)
            {
                //PLAYER CARD SET
                if(player.get(player.size()-1)==Pikachu)
                {
                    PikachuImg.setLayoutX(617);
                    PikachuImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Bulbasaur)
                {
                    BulbasaurImg.setLayoutX(617);
                    BulbasaurImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Psyduck)
                {
                    PsyduckImg.setLayoutX(617);
                    PsyduckImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Snorlax)
                {
                    SnorlaxImg.setLayoutX(617);
                    SnorlaxImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Butterfree)
                {
                    ButterfreeImg.setLayoutX(617);
                    ButterfreeImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Squirtle)
                {
                    SquirtleImg.setLayoutX(617);
                    SquirtleImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Zubat)
                {
                    ZubatImg.setLayoutX(617);
                    ZubatImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Charmander)
                {
                    CharmanderImg.setLayoutX(617);
                    CharmanderImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Meowth)
                {
                    MeowthImg.setLayoutX(617);
                    MeowthImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Jigglypuff)
                {
                    JigglypuffImg.setLayoutX(617);
                    JigglypuffImg.setLayoutY(452);
                }

                //AI CARD SET

                if(AI.get(AI.size()-1)==Pikachu)
                {
                    PikachuImg.setLayoutX(617);
                    PikachuImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Bulbasaur)
                {
                    BulbasaurImg.setLayoutX(617);
                    BulbasaurImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Psyduck)
                {
                    PsyduckImg.setLayoutX(617);
                    PsyduckImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Snorlax)
                {
                    SnorlaxImg.setLayoutX(617);
                    SnorlaxImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Butterfree)
                {
                    ButterfreeImg.setLayoutX(617);
                    ButterfreeImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Squirtle)
                {
                    SquirtleImg.setLayoutX(617);
                    SquirtleImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Zubat)
                {
                    ZubatImg.setLayoutX(617);
                    ZubatImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Charmander)
                {
                    CharmanderImg.setLayoutX(617);
                    CharmanderImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Meowth)
                {
                    MeowthImg.setLayoutX(617);
                    MeowthImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Jigglypuff)
                {
                    JigglypuffImg.setLayoutX(617);
                    JigglypuffImg.setLayoutY(0);
                }
            }
        }
        else {
            for (int i=0; i<3;i++)
            {
                //PLAYER CARD SET
                if(player.get(player.size()-1)==Pikachu)
                {
                    PikachuImg.setLayoutX(490);
                    PikachuImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Bulbasaur)
                {
                    BulbasaurImg.setLayoutX(490);
                    BulbasaurImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Psyduck)
                {
                    PsyduckImg.setLayoutX(490);
                    PsyduckImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Snorlax)
                {
                    SnorlaxImg.setLayoutX(490);
                    SnorlaxImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Butterfree)
                {
                    ButterfreeImg.setLayoutX(490);
                    ButterfreeImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Squirtle)
                {
                    SquirtleImg.setLayoutX(490);
                    SquirtleImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Zubat)
                {
                    ZubatImg.setLayoutX(490);
                    ZubatImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Charmander)
                {
                    CharmanderImg.setLayoutX(490);
                    CharmanderImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Meowth)
                {
                    MeowthImg.setLayoutX(490);
                    MeowthImg.setLayoutY(452);
                }
                if(player.get(player.size()-1)==Jigglypuff)
                {
                    JigglypuffImg.setLayoutX(490);
                    JigglypuffImg.setLayoutY(452);
                }

                //AI CARD SET

                if(AI.get(AI.size()-1)==Pikachu)
                {
                    PikachuImg.setLayoutX(490);
                    PikachuImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Bulbasaur)
                {
                    BulbasaurImg.setLayoutX(490);
                    BulbasaurImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Psyduck)
                {
                    PsyduckImg.setLayoutX(490);
                    PsyduckImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Snorlax)
                {
                    SnorlaxImg.setLayoutX(490);
                    SnorlaxImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Butterfree)
                {
                    ButterfreeImg.setLayoutX(490);
                    ButterfreeImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Squirtle)
                {
                    SquirtleImg.setLayoutX(490);
                    SquirtleImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Zubat)
                {
                    ZubatImg.setLayoutX(490);
                    ZubatImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Charmander)
                {
                    CharmanderImg.setLayoutX(490);
                    CharmanderImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Meowth)
                {
                    MeowthImg.setLayoutX(490);
                    MeowthImg.setLayoutY(0);
                }
                if(AI.get(AI.size()-1)==Jigglypuff)
                {
                    JigglypuffImg.setLayoutX(490);
                    JigglypuffImg.setLayoutY(0);
                }
            }
        }
        isSecondTour = true;
    }

    int nextTourCounter = 0;
    void ShuffleAfterNextTour()
    {
        if(nextTourCounter<2)
        {
            Random random = new Random();
            player.add(pokemons.get(random.nextInt(pokemons.size())));
            for (int j=0; j<pokemons.size();j++)
            {
                if(player.get(player.size()-1)== pokemons.get(j))
                {
                    pokemons.remove(j);
                }
            }
            AI.add(pokemons.get(random.nextInt(pokemons.size())));
            for (int j=0; j<pokemons.size();j++)
            {
                if(AI.get(AI.size()-1)== pokemons.get(j))
                {
                    pokemons.remove(j);
                }
            }
        }
        subShuffle();
        nextTourCounter++;


    }

    @FXML
    void closesettings(MouseEvent event) {
        settingsbar.setVisible(false);

    }

    int gameOverCounter =0;
    @FXML
    void nextTourClick(MouseEvent event) {
        removeMiddleImages();
        if(aiCheckBox.isSelected())
        {
            nextTourAi1Play();
            nextTourAi2Play();
        }
        if(gameOverCounter == 4)
        {
            if(aiCheckBox.isSelected())
            {
                if(Integer.valueOf(playerScore.getText()) > Integer.valueOf(AIscore.getText()))
                {
                    ai1Wins.setVisible(true);
                    return;
                }
                if(Integer.valueOf(playerScore.getText()) < Integer.valueOf(AIscore.getText()))
                {
                    ai2Wins.setVisible(true);
                    return;
                }
                if(Integer.valueOf(playerScore.getText()) == Integer.valueOf(AIscore.getText()))
                {
                    drawScreen.setVisible(true);
                    return;
                }
            }
            else
            {
                if(Integer.valueOf(playerScore.getText()) > Integer.valueOf(AIscore.getText()))
                {
                    winScreen.setVisible(true);
                    return;
                }
                if(Integer.valueOf(playerScore.getText()) < Integer.valueOf(AIscore.getText()))
                {
                    loseScreen.setVisible(true);
                    return;
                }
                if(Integer.valueOf(playerScore.getText()) == Integer.valueOf(AIscore.getText()))
                {
                    drawScreen.setVisible(true);
                    return;
                }
            }

        }
        deletePlayerObject();
        removeFromAiArrayList();
        if (aiCheckBox.isSelected())
        {
            deleteAIObject();
            removeFromAi2ArrayList();
            AP2=0;
        }
        AP=0;
        int numberOfCardsLeft = 4;
        numberOfCardsLeft -=2;
        cardsLeft.setText(String.valueOf(numberOfCardsLeft));
        ShuffleAfterNextTour();
        gameOverCounter++;

    }

    @FXML
    void opensettings(MouseEvent event) {
        settingsbar.setVisible(true);
    }

    void nextTourAi1Play()
    {
        objectToDelete = o;
        AIChooseCard();
        setImageLocation();

        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    void nextTourAi2Play()
    {
        objectToDelete2 = o2;
        AI2ChooseCard();
        setImageLocationAI();

        if(AP2<AP)
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP2>AP)
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    void AIChooseCard()
    {
        for(int i=0;i<AI.size();i++)
        {
            if (Pikachu==AI.get(i))
            {
                if(AP<Pikachu.getAP())
                {
                    AP=Pikachu.getAP();
                    o = Pikachu;
                }
            }
            if (Psyduck==AI.get(i))
            {
                if(AP<Psyduck.getAP())
                {
                    AP=Psyduck.getAP();
                    o = Psyduck;
                }
            }
            if (Snorlax==AI.get(i))
            {
                if(AP<Snorlax.getAP())
                {
                    AP=Snorlax.getAP();
                    o = Snorlax;
                }
            }
            if (Butterfree==AI.get(i))
            {
                if(AP<Butterfree.getAP())
                {
                    AP=Butterfree.getAP();
                    o = Butterfree;
                }
            }
            if (Charmander==AI.get(i))
            {
                if(AP<Charmander.getAP())
                {
                    AP=Charmander.getAP();
                    o = Charmander;
                }
            }
            if (Squirtle==AI.get(i))
            {
                if(AP<Squirtle.getAP())
                {
                    AP=Squirtle.getAP();
                    o = Squirtle;
                }
            }
            if (Jigglypuff==AI.get(i))
            {
                if(AP<Jigglypuff.getAP())
                {
                    AP=Jigglypuff.getAP();
                    o = Jigglypuff;
                }
            }
            if (Bulbasaur==AI.get(i))
            {
                if(AP<Bulbasaur.getAP())
                {
                    AP=Bulbasaur.getAP();
                    o = Bulbasaur;
                }
            }
            if (Zubat==AI.get(i))
            {
                if(AP<Zubat.getAP())
                {
                    AP=Zubat.getAP();
                    o = Zubat;
                }
            }
            if (Meowth==AI.get(i))
            {
                if(AP<Meowth.getAP())
                {
                    AP=Meowth.getAP();
                    o = Meowth;
                }
            }
        }
    }

    void AI2ChooseCard()
    {
        for(int i=0;i<player.size();i++)
        {
            if (Pikachu==player.get(i))
            {
                if(AP2<Pikachu.getAP())
                {
                    AP2=Pikachu.getAP();
                    o2 = Pikachu;
                }
            }
            if (Psyduck==player.get(i))
            {
                if(AP2<Psyduck.getAP())
                {
                    AP2=Psyduck.getAP();
                    o2 = Psyduck;
                }
            }
            if (Snorlax==player.get(i))
            {
                if(AP2<Snorlax.getAP())
                {
                    AP2=Snorlax.getAP();
                    o2 = Snorlax;
                }
            }
            if (Butterfree==player.get(i))
            {
                if(AP2<Butterfree.getAP())
                {
                    AP2=Butterfree.getAP();
                    o2 = Butterfree;
                }
            }
            if (Charmander==player.get(i))
            {
                if(AP2<Charmander.getAP())
                {
                    AP2=Charmander.getAP();
                    o2 = Charmander;
                }
            }
            if (Squirtle==player.get(i))
            {
                if(AP2<Squirtle.getAP())
                {
                    AP2=Squirtle.getAP();
                    o2 = Squirtle;
                }
            }
            if (Jigglypuff==player.get(i))
            {
                if(AP2<Jigglypuff.getAP())
                {
                    AP2=Jigglypuff.getAP();
                    o2 = Jigglypuff;
                }
            }
            if (Bulbasaur==player.get(i))
            {
                if(AP2<Bulbasaur.getAP())
                {
                    AP2=Bulbasaur.getAP();
                    o2 = Bulbasaur;
                }
            }
            if (Zubat==player.get(i))
            {
                if(AP2<Zubat.getAP())
                {
                    AP2=Zubat.getAP();
                    o2 = Zubat;
                }
            }
            if (Meowth==player.get(i))
            {
                if(AP2<Meowth.getAP())
                {
                    AP2=Meowth.getAP();
                    o2 = Meowth;
                }
            }
        }
    }

    void removeFromAiArrayList()
    {
        if(o ==Pikachu)
        {
            AI.remove(Pikachu);
        }
        if(o ==Bulbasaur)
        {
            AI.remove(Bulbasaur);
        }
        if(o ==Psyduck)
        {
            AI.remove(Psyduck);
        }
        if(o ==Jigglypuff)
        {
            AI.remove(Jigglypuff);
        }
        if(o == Snorlax)
        {
            AI.remove(Snorlax);
        }
        if(o == Charmander)
        {
            AI.remove(Charmander);
        }
        if(o ==Zubat)
        {
            AI.remove(Zubat);
        }
        if(o ==Squirtle)
        {
            AI.remove(Squirtle);
        }
        if(o ==Butterfree)
        {
            AI.remove(Butterfree);
        }
        if(o ==Meowth)
        {
            AI.remove(Meowth);
        }
    }

    void removeFromAi2ArrayList()
    {
        if(o2 ==Pikachu)
        {
            player.remove(Pikachu);
        }
        if(o2 ==Bulbasaur)
        {
            player.remove(Bulbasaur);
        }
        if(o2 ==Psyduck)
        {
            player.remove(Psyduck);
        }
        if(o2 ==Jigglypuff)
        {
            player.remove(Jigglypuff);
        }
        if(o2 == Snorlax)
        {
            player.remove(Snorlax);
        }
        if(o2 == Charmander)
        {
            player.remove(Charmander);
        }
        if(o2 ==Zubat)
        {
            player.remove(Zubat);
        }
        if(o2 ==Squirtle)
        {
            player.remove(Squirtle);
        }
        if(o2 ==Butterfree)
        {
            player.remove(Butterfree);
        }
        if(o2 ==Meowth)
        {
            player.remove(Meowth);
        }
    }

    void setImageLocation()
    {
        if(o ==Pikachu)
        {
            PikachuImg.setLayoutX(310);
            PikachuImg.setLayoutY(224);

        }
        if(o ==Bulbasaur)
        {
            BulbasaurImg.setLayoutX(310);
            BulbasaurImg.setLayoutY(224);
        }
        if(o ==Psyduck)
        {
            PsyduckImg.setLayoutX(310);
            PsyduckImg.setLayoutY(224);
        }
        if(o ==Jigglypuff)
        {
            JigglypuffImg.setLayoutX(310);
            JigglypuffImg.setLayoutY(224);
        }
        if(o == Snorlax)
        {
            SnorlaxImg.setLayoutX(310);
            SnorlaxImg.setLayoutY(224);
        }
        if(o == Charmander)
        {
            CharmanderImg.setLayoutX(310);
            CharmanderImg.setLayoutY(224);
        }
        if(o ==Zubat)
        {
            ZubatImg.setLayoutX(310);
            ZubatImg.setLayoutY(224);
        }
        if(o ==Squirtle)
        {
            SquirtleImg.setLayoutX(310);
            SquirtleImg.setLayoutY(224);
        }
        if(o ==Butterfree)
        {
            ButterfreeImg.setLayoutX(310);
            ButterfreeImg.setLayoutY(224);
        }
        if(o ==Meowth)
        {
            MeowthImg.setLayoutX(310);
            MeowthImg.setLayoutY(224);
        }
    }

    void setImageLocationAI()
    {
        if(o2 ==Pikachu)
        {
            PikachuImg.setLayoutX(183);
            PikachuImg.setLayoutY(224);

        }
        if(o2 ==Bulbasaur)
        {
            BulbasaurImg.setLayoutX(183);
            BulbasaurImg.setLayoutY(224);
        }
        if(o2 ==Psyduck)
        {
            PsyduckImg.setLayoutX(183);
            PsyduckImg.setLayoutY(224);
        }
        if(o2 ==Jigglypuff)
        {
            JigglypuffImg.setLayoutX(183);
            JigglypuffImg.setLayoutY(224);
        }
        if(o2 == Snorlax)
        {
            SnorlaxImg.setLayoutX(183);
            SnorlaxImg.setLayoutY(224);
        }
        if(o2 == Charmander)
        {
            CharmanderImg.setLayoutX(183);
            CharmanderImg.setLayoutY(224);
        }
        if(o2 ==Zubat)
        {
            ZubatImg.setLayoutX(183);
            ZubatImg.setLayoutY(224);
        }
        if(o2 ==Squirtle)
        {
            SquirtleImg.setLayoutX(183);
            SquirtleImg.setLayoutY(224);
        }
        if(o2 ==Butterfree)
        {
            ButterfreeImg.setLayoutX(183);
            ButterfreeImg.setLayoutY(224);
        }
        if(o2 ==Meowth)
        {
            MeowthImg.setLayoutX(183);
            MeowthImg.setLayoutY(224);
        }
    }

    void removeMiddleImages()
    {
        if(o ==Pikachu)
        {
            PikachuImg.setDisable(true);
            PikachuImg.setVisible(false);
        }
        if(o ==Bulbasaur)
        {
            BulbasaurImg.setDisable(true);
            BulbasaurImg.setVisible(false);
        }
        if(o ==Psyduck)
        {
            PsyduckImg.setDisable(true);
            PsyduckImg.setVisible(false);
        }
        if(o ==Jigglypuff)
        {
            JigglypuffImg.setDisable(true);
            JigglypuffImg.setVisible(false);
        }
        if(o == Snorlax)
        {
            SnorlaxImg.setDisable(true);
            SnorlaxImg.setVisible(false);
        }
        if(o == Charmander)
        {
            CharmanderImg.setDisable(true);
            CharmanderImg.setVisible(false);
        }
        if(o ==Zubat)
        {
            ZubatImg.setDisable(true);
            ZubatImg.setVisible(false);
        }
        if(o ==Squirtle)
        {
            SquirtleImg.setDisable(true);
            SquirtleImg.setVisible(false);
        }
        if(o ==Butterfree)
        {
            ButterfreeImg.setDisable(true);
            ButterfreeImg.setVisible(false);
        }
        if(o ==Meowth)
        {
            MeowthImg.setDisable(true);
            MeowthImg.setVisible(false);
        }
    }

    void deleteAIObject()
    {
        if(objectToDelete2 ==Pikachu)
        {
            PikachuImg.setDisable(true);
            PikachuImg.setVisible(false);
        }
        if(objectToDelete2 ==Bulbasaur)
        {
            BulbasaurImg.setDisable(true);
            BulbasaurImg.setVisible(false);
        }
        if(objectToDelete2 ==Psyduck)
        {
            PsyduckImg.setDisable(true);
            PsyduckImg.setVisible(false);
        }
        if(objectToDelete2 ==Jigglypuff)
        {
            JigglypuffImg.setDisable(true);
            JigglypuffImg.setVisible(false);
        }
        if(objectToDelete2 == Snorlax)
        {
            SnorlaxImg.setDisable(true);
            SnorlaxImg.setVisible(false);
        }
        if(objectToDelete2 == Charmander)
        {
            CharmanderImg.setDisable(true);
            CharmanderImg.setVisible(false);
        }
        if(objectToDelete2 ==Zubat)
        {
            ZubatImg.setDisable(true);
            ZubatImg.setVisible(false);
        }
        if(objectToDelete2 ==Squirtle)
        {
            SquirtleImg.setDisable(true);
            SquirtleImg.setVisible(false);
        }
        if(objectToDelete2 ==Butterfree)
        {
            ButterfreeImg.setDisable(true);
            ButterfreeImg.setVisible(false);
        }
        if(objectToDelete2 ==Meowth)
        {
            MeowthImg.setDisable(true);
            MeowthImg.setVisible(false);
        }
    }

    void deletePlayerObject()
    {
        if(objectToDelete ==Pikachu)
        {
            PikachuImg.setDisable(true);
            PikachuImg.setVisible(false);
        }
        if(objectToDelete ==Bulbasaur)
        {
            BulbasaurImg.setDisable(true);
            BulbasaurImg.setVisible(false);
        }
        if(objectToDelete ==Psyduck)
        {
            PsyduckImg.setDisable(true);
            PsyduckImg.setVisible(false);
        }
        if(objectToDelete ==Jigglypuff)
        {
            JigglypuffImg.setDisable(true);
            JigglypuffImg.setVisible(false);
        }
        if(objectToDelete == Snorlax)
        {
            SnorlaxImg.setDisable(true);
            SnorlaxImg.setVisible(false);
        }
        if(objectToDelete == Charmander)
        {
            CharmanderImg.setDisable(true);
            CharmanderImg.setVisible(false);
        }
        if(objectToDelete ==Zubat)
        {
            ZubatImg.setDisable(true);
            ZubatImg.setVisible(false);
        }
        if(objectToDelete ==Squirtle)
        {
            SquirtleImg.setDisable(true);
            SquirtleImg.setVisible(false);
        }
        if(objectToDelete ==Butterfree)
        {
            ButterfreeImg.setDisable(true);
            ButterfreeImg.setVisible(false);
        }
        if(objectToDelete ==Meowth)
        {
            MeowthImg.setDisable(true);
            MeowthImg.setVisible(false);
        }
    }

    @FXML
    void BulbasaurClick(MouseEvent event) {
        Bulbasaur.setKullanildiMi(true);
        objectToDelete = Bulbasaur;
        BulbasaurImg.setLayoutX(183);
        BulbasaurImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();

        if(AP>Bulbasaur.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Bulbasaur.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void ButterfreeClick(MouseEvent event) {
        Butterfree.setKullanildiMi(true);
        objectToDelete = Butterfree;

        ButterfreeImg.setLayoutX(183);
        ButterfreeImg.setLayoutY(224);
        AIChooseCard();
        setImageLocation();

        if(AP>Butterfree.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Butterfree.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }

        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));

    }

    @FXML
    void CharmanderClick(MouseEvent event) {
        Charmander.setKullanildiMi(true);
        objectToDelete = Charmander;

        CharmanderImg.setLayoutX(183);
        CharmanderImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Charmander.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Charmander.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));

    }

    @FXML
    void JigglypuffClick(MouseEvent event) {
        Jigglypuff.setKullanildiMi(true);
        objectToDelete = Jigglypuff;

        JigglypuffImg.setLayoutX(183);
        JigglypuffImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Jigglypuff.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Jigglypuff.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));

    }

    @FXML
    void MeowthClick(MouseEvent event) {
        Meowth.setKullanildiMi(true);
        objectToDelete = Meowth;

        MeowthImg.setLayoutX(183);
        MeowthImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Meowth.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Meowth.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void PikachuClick(MouseEvent event) {
        Pikachu.setKullanildiMi(true);
        objectToDelete = Pikachu;

        PikachuImg.setLayoutX(183);
        PikachuImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Pikachu.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Pikachu.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void PsyduckClick(MouseEvent event) {
        Psyduck.setKullanildiMi(true);
        objectToDelete = Psyduck;

        PsyduckImg.setLayoutX(183);
        PsyduckImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Psyduck.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Psyduck.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void SnorlaxClick(MouseEvent event) {
        Snorlax.setKullanildiMi(true);
        objectToDelete = Snorlax;

        SnorlaxImg.setLayoutX(183);
        SnorlaxImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Snorlax.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Snorlax.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void SquirtleClick(MouseEvent event) {
        Squirtle.setKullanildiMi(true);
        objectToDelete = Squirtle;

        SquirtleImg.setLayoutX(183);
        SquirtleImg.setLayoutY(224);
        AIChooseCard();

        setImageLocation();
        if(AP>Squirtle.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Squirtle.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }

    @FXML
    void ZubatClick(MouseEvent event) {
        Zubat.setKullanildiMi(true);
        objectToDelete = Zubat;
        AIChooseCard();
        setImageLocation();

        ZubatImg.setLayoutX(183);
        ZubatImg.setLayoutY(224);
        if(AP>Zubat.getAP())
        {
            bilgisayarOyuncu.setSkor(bilgisayarOyuncu.getSkor()+5);
        }
        if(AP<Zubat.getAP())
        {
            insanOyuncu.setSkor(insanOyuncu.getSkor()+5);
        }
        System.out.println(AP+" "+o);
        System.out.println(insanOyuncu.getSkor()+" "+bilgisayarOyuncu.getSkor());
        AIscore.setText(String.valueOf(bilgisayarOyuncu.getSkor()));
        playerScore.setText(String.valueOf(insanOyuncu.getSkor()));
    }


    @FXML
    void Restart() {
        //WinPane.setVisible(false);
        //GameOverPane.setVisible(false);
        Stage stage = (Stage)RestartButton.getScene().getWindow();
        stage.close();
        stage.show();
    }

    @FXML
    void startgame(ActionEvent event) {
        StartPane.setVisible(false);
        if(aiCheckBox.isSelected())
        {
            firstPlayer.setText("AI 1");
            secondPlayer.setText("AI 2");
        }
        if(userCheckBox.isSelected())
        {

        }
    }
    @FXML
    void Quit() {
        Stage stage = (Stage)QuitButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Shuffle();



    }
}