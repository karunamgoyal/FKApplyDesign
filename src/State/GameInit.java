package src.State;

public class GameInit{

    public static State[][][] initState(int side, int level){
        State [][][] state = new State[level][][];
        for(int i = 0;i<level;i++){
            state[i] = new State[(int)Math.pow(side,level-1-i)][(int)Math.pow(side,level-1-i)];
        }
        for(int k = 0;k<level;k++){
            for(int i=0;i<Math.pow(side,level-1-k);i++){
                for(int j=0;j<Math.pow(side,level-1-k);j++){
                    state[k][i][j] = new State(side);
                }
            }   
        }
        return state;
    }
    public static Hex[][][] initHex(int side,int level){
        Hex [][][] state = new Hex[level][][];
        for(int i = 0;i<level;i++){
            state[i] = new Hex[(int)Math.pow(2*side-1,level-1-i)][(int)Math.pow(4*side-3,level-1-i)];
        }

        for(int k = 0;k<level;k++){
            int r = (int)Math.pow(2*side-1,level-1-k);
            int c = (int)Math.pow(2*r-1,level-1-k);
            for(int i=0;i<r;i++){
                for(int j=Math.abs(i-(r/2));j<c-Math.abs(i-(r/2));j+=2){
                    state[k][i][j] = new Hex(side);
                }
            } 
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(state[k][i][j] ==null){
                        state[k][i][j]=new Hex(side, -1);
                    }
                }
            }    
        }   
        return state; 
    }

}