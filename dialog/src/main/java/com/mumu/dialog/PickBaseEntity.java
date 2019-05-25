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
public class PickBaseEntity implements Serializable {


    /**
     * timestamp : 1558772976207
     * resthead : {"errorCode":0,"message":""}
     * restbody : {"higherLevel":[{"id":251,"name":"北沥村"}]}
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
        private List<HigherLevelBean> higherLevel;

        public List<HigherLevelBean> getHigherLevel() {
            return higherLevel;
        }

        public void setHigherLevel(List<HigherLevelBean> higherLevel) {
            this.higherLevel = higherLevel;
        }

        public static class HigherLevelBean {
            public HigherLevelBean(int id, String name) {
                this.id = id;
                this.name = name;
                this.isChecked = false;
            }

            /**
             * id : 251
             * name : 北沥村
             */

            private int id;
            private String name;
            private boolean isChecked = false;

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
