


public class Main {
	
	public static void main(String[] args){
		String exp="1^0|0|1";
		System.out.println(f(exp,false,0,exp.length()-1));

	}
	
	public static int f(String exp, boolean result, int s, int e){
		if(s==e){
			if(exp.charAt(s)=='1' && result){
				return 1;
			}else if(exp.charAt(s)=='0' && !result){
				return 1;
			}
			return 0;
		}
		int w=0;//ways
		if(result){
			for(int i=s+1;i<=e;i+=2){
				char op=exp.charAt(i);
				if(op=='&'){
					w+=f(exp,true,s,i-1)*f(exp,true,i+1,e);
				}else if(op=='|'){
					w+=f(exp,true,s,i-1)*f(exp,true,i+1,e)+
					   f(exp,true,s,i-1)*f(exp,false,i+1,e)+
					   f(exp,false,s,i-1)*f(exp,true,i+1,e);			   
				}else if(op=='^'){
					w+=f(exp,true,s,i-1)*f(exp,false,i+1,e)+
					   f(exp,false,s,i-1)*f(exp,true,i+1,e);
				}
			}
		}else{
			for(int i=s+1;i<=e;i+=2){
				char op=exp.charAt(i);
				if(op=='|'){
					w+=f(exp,false,s,i-1)*f(exp,false,i+1,e);
				}else if(op=='&'){
					w+=f(exp,false,s,i-1)*f(exp,false,i+1,e)+
					   f(exp,true,s,i-1)*f(exp,false,i+1,e)+
					   f(exp,false,s,i-1)*f(exp,true,i+1,e);			   
				}else if(op=='^'){
					w+=f(exp,true,s,i-1)*f(exp,true,i+1,e)+
					   f(exp,false,s,i-1)*f(exp,false,i+1,e);
				}
			}
		}
		return w;
	}

}
