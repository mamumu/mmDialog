package com.mumu.dialog;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zlf
 * date    : 2019/5/24
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class PickEntity implements Serializable {


    /**
     * timestamp : 1558772976207
     * resthead : {"errorCode":0,"message":""}
     * restbody : {"higher1Level":[{"id":251,"name":"北沥村"},{"id":251,"name":"北沥村"},{"id":251,"name":"北沥村"},{"id":251,"name":"北沥村"}],"higher2Level":[{"id":251,"name":"北沥村"},{"id":251,"name":"北沥村"}],"higher3Level":[{"id":251,"name":"北沥村"}]}
     * extend : null
     */

    private long timestamp;
    private RestheadBean resthead;
    private RestbodyBean restbody;
    private Object extend;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public RestheadBean getResthead() {
        return resthead;
    }

    public void setResthead(RestheadBean resthead) {
        this.resthead = resthead;
    }

    public RestbodyBean getRestbody() {
        return restbody;
    }

    public void setRestbody(RestbodyBean restbody) {
        this.restbody = restbody;
    }

    public Object getExtend() {
        return extend;
    }

    public void setExtend(Object extend) {
        this.extend = extend;
    }

    public static class RestheadBean {
        /**
         * errorCode : 0
         * message :
         */

        private int errorCode;
        private String message;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class RestbodyBean {
        private List<Higher1LevelBean> higher1Level;
        private List<Higher2LevelBean> higher2Level;
        private List<Higher3LevelBean> higher3Level;

        public List<Higher1LevelBean> getHigher1Level() {
            return higher1Level;
        }

        public void setHigher1Level(List<Higher1LevelBean> higher1Level) {
            this.higher1Level = higher1Level;
        }

        public List<Higher2LevelBean> getHigher2Level() {
            return higher2Level;
        }

        public void setHigher2Level(List<Higher2LevelBean> higher2Level) {
            this.higher2Level = higher2Level;
        }

        public List<Higher3LevelBean> getHigher3Level() {
            return higher3Level;
        }

        public void setHigher3Level(List<Higher3LevelBean> higher3Level) {
            this.higher3Level = higher3Level;
        }

        public static class Higher1LevelBean {
            /**
             * id : 251
             * name : 北沥村
             */

            private int id;
            private String name;
            private boolean isChecked = false;

            public Higher1LevelBean(int id, String name) {
                this.id = id;
                this.name = name;
                this.isChecked = false;
            }

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class Higher2LevelBean {
            /**
             * id : 251
             * name : 北沥村
             */

            private int id;
            private String name;
            private boolean isChecked = false;

            public Higher2LevelBean(int id, String name) {
                this.id = id;
                this.name = name;
                this.isChecked = false;
            }

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class Higher3LevelBean {
            /**
             * id : 251
             * name : 北沥村
             */

            private int id;
            private String name;
            private boolean isChecked = false;

            public Higher3LevelBean(int id, String name) {
                this.id = id;
                this.name = name;
                this.isChecked = false;
            }

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
