package com.macina.room.startData;

import com.macina.room.entities.bodyGroup.BodyGroup;
import com.macina.room.entities.bodyGroup.BodyGroupRepository;
import com.macina.room.entities.exercise.Exercise;
import com.macina.room.entities.exercise.ExerciseRepository;
import com.macina.room.entities.user.UserApp;
import com.macina.room.entities.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StartDataService {

    private final BodyGroupRepository bodyGroupRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;
    public static final Set<String> ALL_MUSCLE_GROUPS = Set.of(
            // Parte superiore
            "Petto",
            "Pettorale maggiore",
            "Pettorale minore",
            "Schiena",
            "Gran dorsale",
            "Trapezio",
            "Trapezio superiore",
            "Romboidi",
            "Erettori spinali",
            "Lombari",

            // Spalle
            "Spalle",
            "Deltoide anteriore",
            "Deltoide laterale",
            "Deltoide posteriore",
            "Deltoidi",
            "Cuffia dei rotatori",

            // Braccia
            "Bicipiti",
            "Bicipite brachiale",
            "Brachiale",
            "Brachioradiale",
            "Tricipiti",
            "Capo lungo tricipite",
            "Capo laterale tricipite",
            "Capo mediale tricipite",
            "Avambracci",
            "Flessori",
            "Estensori",

            // Core
            "Addominali",
            "Retto addominale",
            "Obliqui",
            "Trasverso dell'addome",
            "Quadrato dei lombi",

            // Parte inferiore
            "Glutei",
            "Grande gluteo",
            "Medio gluteo",
            "Piccolo gluteo",
            "Quadricipiti",
            "Retto femorale",
            "Vasto laterale",
            "Vasto mediale",
            "Vasto intermedio",
            "Femorali",
            "Bicipite femorale",
            "Semitendinoso",
            "Semimembranoso",
            "Adduttori",
            "Abduttori",
            "Polpacci",
            "Gastrocnemio",
            "Soleo",
            "Tibiale anteriore",
            "Flessori dell'anca",
            "Ileopsoas",
            "Sartorio",

            // Specifici / Accessori
            "Dentato anteriore",
            "Serratus",
            "Intercostali",
            "Scaleni"
    );

    @PostConstruct
    public void init() {
        initBodyGroups();
        initExercises();
        initUsers();
    }

    public void initUsers(){
        UserApp u = new UserApp(
                "default","def@email.com"
        );
        if(!userRepository.existsByUsername(u.getUsername())){
            userRepository.save(u);
        }
    }
    public void initBodyGroups() {
        for (String bodyGroupName : ALL_MUSCLE_GROUPS) {
            boolean exists = bodyGroupRepository.existsByName(bodyGroupName);
            if (!exists) {
                BodyGroup bodyGroup = new BodyGroup();
                bodyGroup.setName(bodyGroupName);
                bodyGroupRepository.save(bodyGroup);
            }
        }
    }
    private void initExercises() {
        // PETTO
        createExerciseIfNotExists("Panca piana", "Distesi su una panca, sollevare il bilanciere dal rack fino a distendere completamente le braccia", "Petto");
        createExerciseIfNotExists("Panca inclinata", "Come la panca piana ma con la panca inclinata a 30-45 gradi", "Petto");
        createExerciseIfNotExists("Panca declinata", "Variante con panca inclinata negativamente", "Petto");
        createExerciseIfNotExists("Crocifisso con manubri", "Aperture laterali su panca per isolare il petto", "Pettorale maggiore");
        createExerciseIfNotExists("Cable crossover", "Croci ai cavi per enfasi sul petto", "Pettorale minore");
        createExerciseIfNotExists("Dips parallele", "Piegamenti alle parallele con enfasi sul petto", "Petto");

        // SCHIENA
        createExerciseIfNotExists("Pull-up", "Trazioni alla sbarra con presa larga", "Gran dorsale");
        createExerciseIfNotExists("Lat machine", "Simulatore di trazioni con carico regolabile", "Gran dorsale");
        createExerciseIfNotExists("Rematore con bilanciere", "Piegati in avanti, tirare il bilanciere verso l'addome", "Schiena");
        createExerciseIfNotExists("T-Bar row", "Variante del rematore con bilanciere", "Schiena");
        createExerciseIfNotExists("Deadlift", "Stacco da terra completo", "Erettori spinali");
        createExerciseIfNotExists("Shrugs con bilanciere", "Alzate delle spalle per i trapezi", "Trapezio superiore");
        createExerciseIfNotExists("Face pull", "Esercizio per deltoidi posteriori e trapezi", "Trapezio");

        // SPALLE
        createExerciseIfNotExists("Military press", "Alzate frontali con bilanciere", "Deltoidi");
        createExerciseIfNotExists("Alzate laterali", "Con manubri, sollevare le braccia lateralmente", "Deltoidi");
        createExerciseIfNotExists("Arnold press", "Shoulder press con rotazione", "Deltoidi");
        createExerciseIfNotExists("Lento dietro", "Spinta del bilanciere dietro la testa", "Spalle");
        createExerciseIfNotExists("External rotation", "Rotazioni esterne per la cuffia dei rotatori", "Cuffia dei rotatori");

        // BRACCIA
        createExerciseIfNotExists("Curl con bilanciere", "Piegamenti delle braccia con bilanciere", "Bicipiti");
        createExerciseIfNotExists("Hammer curl", "Curl con presa neutra", "Bicipiti");
        createExerciseIfNotExists("French press", "Estensioni del bilanciere dietro la testa", "Tricipiti");
        createExerciseIfNotExists("Dip machine", "Macchina per dip assistiti", "Tricipiti");
        createExerciseIfNotExists("Wrist curl", "Curl per avambracci", "Avambracci");

        // ADDOMINALI E CORE
        createExerciseIfNotExists("Crunch", "Piegamenti del busto da supini", "Addominali");
        createExerciseIfNotExists("Russian twist", "Rotazioni del busto con peso", "Obliqui");
        createExerciseIfNotExists("Hyperextension", "Estensioni del busto per la zona lombare", "Lombari");
        createExerciseIfNotExists("Plank", "Tenuta isometrica in posizione di push-up", "Addominali");

        // GAMBE
        createExerciseIfNotExists("Squat", "Piegamento delle gambe con bilanciere", "Quadricipiti");
        createExerciseIfNotExists("Leg press", "Spinta del carico con le gambe", "Quadricipiti");
        createExerciseIfNotExists("Leg curl", "Piegamenti delle gambe alla macchina", "Femorali");
        createExerciseIfNotExists("Hip thrust", "Spinta del bacino con bilanciere", "Glutei");
        createExerciseIfNotExists("Calf raise", "Sollevamenti sulle punte", "Polpacci");
        createExerciseIfNotExists("Leg extension", "Estensioni delle gambe alla macchina", "Quadricipiti");
        createExerciseIfNotExists("Bulgarian split squat", "Squat su una gamba sola", "Quadricipiti");
        createExerciseIfNotExists("Adductor machine", "Macchina per adduttori", "Adduttori");
        createExerciseIfNotExists("Abductor machine", "Macchina per abduttori", "Abduttori");
    }


    private void createExerciseIfNotExists(String name, String description, String bodyGroupName) {
        if (!exerciseRepository.existsByName(name)) {
            BodyGroup bodyGroup = bodyGroupRepository.findByName(bodyGroupName)
                    .orElseThrow(() -> new RuntimeException("Body group not found: " + bodyGroupName));

            Exercise exercise = new Exercise();
            exercise.setName(name);
            exercise.setDescription(description);
            exercise.setBodyGroup(bodyGroup);
            exerciseRepository.save(exercise);
        }
    }


}
