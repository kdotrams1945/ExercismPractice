package Leet.DivT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Tag;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AnnalynsInfiltrationTest {
    @Test


    public void cannot_execute_fast_attack_if_knight_is_awake() {
        boolean knightIsAwake = true;
        assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isFalse();
    }
}