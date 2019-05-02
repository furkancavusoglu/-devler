public class Instruction {
    StringBuilder instruction=new StringBuilder();
    Instruction(int ... i) {
        for(int element:i){
            instruction.append(element);
        }
    }

}
