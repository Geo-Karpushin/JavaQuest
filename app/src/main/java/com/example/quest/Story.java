package com.example.quest;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    Story(MainActivity mainActivity) {
        current_situation = start_story;
        start_story = new Situation(
                "---===Первый день в Мафии===---",
                "Ну чтож, " + MainActivity.player.name + ".. Я искал тебя чтобы предложить работу, но ты конечно можешь сделать и неугодное мне решение *на вас навели пистолет*\n"
                        + "(1) 'Хорошо.. Я буду работать на тебя...'\n"
                        + "(2) 'Ни за что! Лучше я умру!'",
                2, 0, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "---===Принят в Мафию===---",
                "'Отлично! Мои люди очень заняты, но чтобы ты не сбежал я дам тебе авансом 100000$, и будь уверен, ты сможешь заработать в разы больше, если останешься работать у меня!'\n"
                        + "(1) Взять деньги",
                1, 0, 0, 10, 0);
        start_story.direction[1] = new Situation(
                "---===Убит в бою===---",
                "'Как скажешь..' *выстрел*\n"
                        + "Вы были убиты..",
                0, 0, 0, -100, 100);
        start_story.direction[0].direction[0] = new Situation(
                "---===Аванс получен===---",
                "'Cледуй за моим человеком, он покажет тебе путь до твоей комнаты'\n"
                        +"(1) Следовать за человеком",
                1, 1, 100000, 5, 0);
        start_story.direction[0].direction[0].direction[0] = new Situation(
                "---===В коридоре===---",
                "Вы идете по коридору за человеком Босса. В коридоре никого нету, вам ничего не мешает сбежать..\n"
                        +"(1) Вырубить проводника и попытаться сбежать\n"+
                        "(2) Продолжать двигаться за проводником",
                2,0,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1] = new Situation(
                "---===Комната===---",
                "Вас привели в комнату и сказали ждать дальнейших указаний\n"
                        +"(1) Попытаться сбежать\n"+
                        "(2) Ждать указаний",
                2,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0] = new Situation(
                "---===Охраник===---",
                "Вы попытались выйти, но путь вам преградил охраник\n"
                        +"(1) 'Где тут у вас туалет?'\n"+
                        "(2) Попробывать его подкупить",
                2,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[1] = new Situation(
                "---===Работа у мафии===---",
                "Ваша жизнь больше не будет прежней. Хоть вы и разбогатели, может лудше было сбежать в первый день?\n",
                0,1000,1000000000,100000,-10000);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0].direction[0] = new Situation(
                "---===Туалет===---",
                "Вас отвели в туалет, вы увидел окно - единственный выход\n"
                        +"Вы забрались на подоконник и прыгнули.. Не лудшая была идея..",
                0,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0].direction[1] = new Situation(
                "---===Корупция повсюду===---",
                "Охранник могласен на 100000$ за то, чтобы вас выпустить\n"
                        +"(1) 'Я согласен..'\n"
                        +"(2) Попытаться сторгаваться.\n"
                        +"(1) 'Я лудше останусь работать на мафию!",
                3,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0].direction[1].direction[0] = new Situation(
                "---==='Свобода'===---",
                "Охранник взял деньги и повёл вас по корридорам. Впереди показался свет..\n"
                        +"Вы ускорились, но обернувшись увидели охранника, он нажал на красную кнопку, достал пистолет и выстрелил..",
                0,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0].direction[1].direction[1] = new Situation(
                "---===Отказ===---",
                "Охранник молча закрыл дверь.\n"
                        +"Вы услышали звук газа.. Вы упали на пол и уснули вечным сном...",
                0,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[1].direction[0].direction[1].direction[2] = new Situation(
                "---===Отказ===---",
                "Охранник молча закрыл дверь.\n"
                        +"Вы услышали звук газа.. Вы упали на пол и уснули вечным сном...",
                0,1,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[0] = new Situation(
                "---===Побег===---",
                "Вы подошли ближе к проводнику, ударили его локтем по голове, он отрубился.. Побег удался..\n"
                        +"(1) Прыгнуть в окно\n"+
                        "(2) Бежать вперед по коридору",
                2,-1,0,-10,0);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[0] = new Situation(
                "---===Вы разбились===---",
                "Вы забрались на подоконник и прыгнули.. Не лудшая была идея..",
                0,0,0,-12,5);
        current_situation = start_story;
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1] = new Situation(
                "---===На развилке===---",
                "Вы добежали до угла коридора, куда же дальше бежать?\n"
                        +"(1) Повернуть налево\n"+
                        "(2) Повернуть направо",
                2,0,0,0,0);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1].direction[0] = new Situation(
                "---===Незванный друг===---",
                "Вы завернули заугол, потом еще раз, но на вашем пути - босс..\n"
                        +"*Вы посмотрели на босса*\n"+
                        "'Я думал мы подружимся' - сказал он, достал пистолет и выстрелил вам в голову...",
                0,-10,0,-100,10);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1].direction[1] = new Situation(
                "---===Выход===---",
                "Вы завернули заугол, потом еще раз, и увидели выход в конце коридора!\n"
                        +"Вы ускорились. Добежав до двери вы дернули за ручку и выбежали наружу\n"+
                        "'Через забор!' - подумали вы, увидив забор..\n"+
                        "Вы перепрыгнули через забор и побежали по улице. Про себя вы думали стоит ли сдавать мафию полиции?\n"+
                        "(1) Стоит, иначе они меня найдут и убьют\n"+
                        "(2) Нет, лудше залеч на дно и не высовываться",
                2,10,0,-100,100);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1].direction[1].direction[0] = new Situation(
                "---===Конец кошмара близок===---",
                "Добежав до участка вы подошли к регистратуре\n"
                        +"(1) 'Я хочю раскрыть местонахождение мафии'",
                1,10,0,-100,100);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1].direction[1].direction[0].direction[0] = new Situation(
                "---===Конец===---",
                "Вы видели как босса уводят в автомобиль и как он на вас смотрит\n"
                        +"А стоило ли это делать?",
                0,100,0,-1000,1000);
        start_story.direction[0].direction[0].direction[0].direction[0].direction[1].direction[1].direction[1] = new Situation(
                "---===Смерть в собственном доме===---",
                "Добежав до своего дома вы открыли дверь и зашли внутрь, закрыли двнерь и облегченно выдохнули\n"
                        +"Вы хотели собрать вещи и уйти, как вдруг вы услышали звук разбитого окна..\n"+
                        "Взрыв гранаты переживет не каждый, темболее если гранат 5 штук..",
                0,-1,0,-100,100);
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
