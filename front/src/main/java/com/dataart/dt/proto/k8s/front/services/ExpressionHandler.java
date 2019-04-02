package com.dataart.dt.proto.k8s.front.services;

import com.dataart.dt.proto.k8s.front.repositories.Add;
import com.dataart.dt.proto.k8s.front.repositories.Mul;
import com.dataart.dt.proto.k8s.front.repositories.PubSub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExpressionHandler {

    private final Add add;

    private final Mul mul;

    private final PubSub pubSub;

    private Logger log = LoggerFactory.getLogger(ExpressionHandler.class);

    private Pattern exprRegexp = Pattern.compile("(\\d+)(\\+|\\*)(\\d+)");

    public ExpressionHandler(Add add, Mul mul, PubSub pubSub) {
        this.add = add;
        this.mul = mul;
        this.pubSub = pubSub;
    }

    public boolean evaluateExpression(String expression) {
        log.info("Evaluating expression {}", expression);
        Matcher m = exprRegexp.matcher(expression);
        if (m.matches()) {
            int n1 = Integer.parseInt(m.group(1));
            String sign = m.group(2);
            int n2 = Integer.parseInt(m.group(3));
            int result;
            switch (sign) {
                case "+": {
                    result = add.add(n1, n2);
                    break;
                }
                case "*": {
                    result = mul.mul(n1, n2);
                    break;
                }
                default: {
                    throw new RuntimeException("This point should not be reached");
                }
            }
            log.info("Expression result: {}", result);
            // push to the queue
            pubSub.sendToPubSub(result);
            return true;
        } else {
            return false;
        }
    }

}
