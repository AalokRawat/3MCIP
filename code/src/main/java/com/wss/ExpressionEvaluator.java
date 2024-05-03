package com.wss;

public class ExpressionEvaluator {
    private static CommandProcessor processor;

    static {
        processor = CommandProcessor.init();
    }

    public static void eval(String cmd) {
        String[] cmd_ops = cmd.split(" ");
        Operation  operation = Operation.valueOf(cmd_ops[0]);
        switch (operation){
        case READ:
            String key = cmd_ops[1];
            System.out.println(processor.read(key));
            break;
        case WRITE:
            key = cmd_ops[1];
            String value = cmd_ops[2];
            processor.write(key, value);
            break;
        case DELETE:
            key = cmd_ops[1];
            processor.delete(key);
            break;
        case START:
            processor = processor.start();
            break;
        case COMMIT:
            processor = processor.commit();
            break;
        case ABORT:
            processor = processor.abort();
            break;
        case QUIT:
            processor.quit();
            break;
        default:
            throw new IllegalStateException("Unexpected Operation: " + operation);
        }
    }
}
