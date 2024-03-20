public class interests {
        public int size=0;
        public int index=0;
        private String[] intrests;
        public interests(int n){
            size=n;
            intrests=new String[n];
        }
        public String[] array(){
            return this.intrests;
        }
        public void add_intrests(String neww){
            intrests[index]=neww;
            this.index++;
        }
        public String index_return(int n){
            return intrests[n];
        }
    }


