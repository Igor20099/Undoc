package com.joymaker.unity.questions;

public class Questions {

    public String questions[] = {
            "Какой компонент отвечает за перемещение объекта(не UI объекта)?",
            "Какой UI объект необходим для добавления и отображения UI объектов?",
            "Можно ли создать пустой игровой объект(GameObject)?",
            "Сколько раз вызывается метод Update?",
            "Какой метод позволяет получить ссылку на компонент у игрового объекта?",
            "Для чего нужен Animator?",
            "Какой источник света в Unity имитирует солнечный свет  и может освещать всю сцену?",
            "Нужно ли сохранять изменения в префабе(Prefab)?",
            "Какой компонент из перечисленных  наделяет объект свойством твердого тела и необходим для проверки столкновений?",
            "Для чего нужен атрибут [SerializeField] в коде?",
            "Можно ли добавить скрипт на объект если класс внутри скрипта не наследуется от класса MonoBehavior?",
            "Какой компонент из перечисленных нужен для того чтобы связать один объект с другим?",
            "Можно ли добавлять несколько одинаковых компонентов на объект?",
            "Что делает метод Instantiate?"
    };

    private String choices [] [] = {
            {"Rect Transform", "Rigidbody","Transform","Mesh Render"},
            {"Canvas", "GameObject", "Panel", "" },
            {"Да","Нет","",""},
            {"Один раз при запуске игры","Раз за кадр","",""},
            {"Instantiate", "GetComponent", "Destroy", "AddComponent"},
            {"Для переключения анимаций", "Для создания анимаций", "Для переключения и создания анимаций",""},
            {"Point Light","Area Light","Spot Light","Directional Light"},
            {"Да", "Нет, они сохраняются автоматически","",""},
            {"Rigidbody","Box Collider","Hingle Joint","Transform"},
            {"Cкрыть приватное поле в инспекторе","Скрыть публичное поле в инспекторе","Отобразить публичное поле в инспекторе","Отобразить приватное поле в инспекторе"},
            {"Да","Нет","",""},
            {"Sphere Collider", "Hingle Joint", "Rigidbody", "Mesh Render"},
            {"Да","Нет","",""},
            {"Уничтожает объект на сцене", "Ищет объект на сцене","Создает объект на сцене",""}
    };

    private String correctAnswers[] = {"Transform","Canvas","Да","Раз за кадр","GetComponent","Для переключения анимаций","Directional Light","Да","Box Collider","Отобразить приватное поле в инспекторе"
            ,"Нет","Hingle Joint","Нет","Создает объект на сцене"
    };

    private String fullCorrectAnswers[] = {

            "Правильный ответ \"Transform\". Именно этот компонент отвечает за перемещиние объекта по трем осям x, y и z.",
            "Правильный ответ \"Canvas\". Именно Canvas(Полотно) нужен для добавления и отображения UI объектов. Даже при добавления какого нибудь UI объекта, создается Canvas и этот объект становится дочерним объектом Canvas",
            "Правильный ответ \"Да\". Для этого нажмите на панели иерархии правой кнопкой мыши и выберите \"Create Empty\"",
            "Правильный ответ \"Раз за кадр\". Метод Update выполняется каждый кадр",
            "Правильный ответ \"GetComponent\". Вы можете получить ссылку на компонент с помощью метода GetComponent. Например Rigidbody rigidbody = GetComponent<Rigidbody>();",
            "Правильный ответ \"Для переключения анимаций\". В окне Animator вы создаете переходы между анимациями. Для этого вы можете создать параметры разных типов в окне Animator и в коде управлять переходами.",
            "Правильный ответ \"Directional Light\". Именно этот источник света имитирует солнечный свет и может освещать всю сцену. По умолчанию создаётся вместе с камерой в 3D проекте",
            "Правильный ответ \"Да\". В префабе(Prefab) нужно сохранять изменения чтобы изменения произошли и на других объектах префаба. Для сохранения в окне инспектора вверху нажмите на Overrides и далее Apply All, а если хотите сбросить настройки то Revert All",
            "Правильный ответ \"Box Collider\". Именно Box Collider и другие коллайдеры служат для наделения объекта свойством твердого тела( и не твердого тела если включить свойство \"Is Trigger\") и для проверки столкновений",
            "Правильный ответ \"Отобразить приватное поле в инспекторе\". Атрибут [SerializeField] отображает в инспекторе поле с модификатором private",
            "Правильный ответ \"Нет\". Класс внутри скрипта должен наследоваться от класса MonoBehavior. Если вы попытаетесь добавить скрипт в качестве компонента на объект то Unity покажет окно с сообщением о том что класс внутри скрипта не наследуется от MonoBehavior",
            "Правильный ответ \"Hingle Joint\". Именно с помощью этого компонента и других джоинтов можно создать связь между двумя объектами. При этом у обоих объектов должен быть компонент Rigidbody",
            "Правильный ответ \"Нет\". Добавлять одинаковые компоненты нельзя. При добавления того же компонента который уже находится на объекте, Unity покажет вам окно с сообщением о том что такой компонент уже висит на объекте",
            "Правильный ответ \"Создает объект на сцене\". Метод Instantiate создает объект на сцене и так же возвращает ссылку на этот объект и эту ссылку вы моежете присвоить переменной типа Object(GameObject наследуется от Object)"


    };

    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getChoice1 (int a) {
        String choice = choices[a][0];
        return choice;
    }
    public String getChoice2 (int a) {
        String choice = choices[a][1];
        return choice;
    }
    public String getChoice3 (int a) {
        String choice = choices[a][2];
        return choice;
    }
    public String getChoice4 (int a) {
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String correctAnswer = correctAnswers[a];
        return correctAnswer;
    }

    public String getFullCorrectAnswer(int a) {
        String fullCorrectAnswer = fullCorrectAnswers[a];
        return fullCorrectAnswer;
    }
}
