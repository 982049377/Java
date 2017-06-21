/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author HP-PC
 */
public class yes {

    interface task {

    }

    interface taskcondition {

        public void Howtofinish();
    }

    class talkNPC implements task {

        int id;
        String name;
        taskcondition condition;

        public talkNPC(taskcondition condition) {
            this.condition = condition;
        }
    }

    class killMonster implements task {

        int id;
        String name;
        taskcondition condition;

        public killMonster(taskcondition condition) {

            this.condition = condition;
        }
    }

    class talkNPCCondition implements taskcondition {

        String type;

        talkNPCCondition() {
            super();
            this.type = "talkNPCCondition";
        }

        public void Howtofinish() {
        }
    }

    class killMonsterCondition implements taskcondition {

        String type;

        killMonsterCondition() {
            super();
            this.type = "talkNPCCondition";
        }

        public void Howtofinish() {
        }
    }
}

class taskManager {

    public static taskManager instance;

    private taskManager() {

    }

    public static taskManager getinstance() {
        if (taskManager.instance == null) {
            taskManager ts = new taskManager();
            taskManager.instance = ts;
        }
        return taskManager.instance;
    }

    yes.task MakeTask(yes.taskcondition condition) {
        if (condition.type == talkNPCCondition) {
            return new yes.talkNPC(condition);
        }
        if (condition.type == killMonsterCondition) {
            return new yes.killMonster(condition);
        }
        return null;
    }
}
