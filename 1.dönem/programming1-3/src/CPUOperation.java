
public class CPUOperation {
    private int[] operandDecimals = new int[2];

    //auxiliary method for converting binary number to decimal
    private int binaryToDecimal(String str) {
        int output = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                output = output + (int) Math.pow(2, str.length() - 1 - i);
        }
        return output;
    }

    //auxiliary method for setting decimal operands
    private void setOperandDecimals(String op1, String op2) {
        CPUOperation cpuOperation = new CPUOperation();
        //checking the number if negative or positive
        int operandDecimal = op1.charAt(0) == '0' ? cpuOperation.binaryToDecimal(op1.substring(1))
                : -1 * cpuOperation.binaryToDecimal(op1.substring(1));
        int operandDecimal2 = op2.charAt(0) == '0' ? cpuOperation.binaryToDecimal(op2.substring(1))
                : -1 * cpuOperation.binaryToDecimal(op2.substring(1));
        operandDecimals[0] = operandDecimal;
        operandDecimals[1] = operandDecimal2;
    }

    int execute(Instruction I) {
        String operator = I.instruction.substring(0, 3);
        String operand1 = I.instruction.substring(3, 8);
        String operand2 = I.instruction.substring(8);
        setOperandDecimals(operand1, operand2);
        switch (operator) {
            case "000":
                return operandDecimals[0] + operandDecimals[1];
            case "001":
                return operandDecimals[0] - operandDecimals[1];
            case "010":
                return operandDecimals[0] * operandDecimals[1];
            case "011":
                return operandDecimals[0] / operandDecimals[1];
            case "100":
                return Math.max(operandDecimals[0], operandDecimals[1]);
            case "101":
                return Math.min(operandDecimals[0], operandDecimals[1]);
            case "110": {
                String onlyOperand = I.instruction.substring(4);
                CPUOperation cpuOp = new CPUOperation();
                return I.instruction.charAt(3) == '1' ? cpuOp.binaryToDecimal(onlyOperand) : -1 * cpuOp.binaryToDecimal(onlyOperand);
            }
            case "111": {
                String onlyOperand = I.instruction.substring(4);
                CPUOperation cpuOp = new CPUOperation();
                return cpuOp.binaryToDecimal(onlyOperand);
            }
        }
        return 0;
    }
}