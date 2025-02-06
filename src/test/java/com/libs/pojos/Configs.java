package com.libs.pojos;

import java.util.Map;

public record Configs(Map<String, Environment> environments) {
}
