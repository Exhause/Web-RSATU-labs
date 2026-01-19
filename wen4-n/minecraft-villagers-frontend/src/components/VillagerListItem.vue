<template>
  <b-container fluid class="p-0">
    <b-row class="align-items-center">
      <b-col cols="11">
        <strong>{{ villager.name }}</strong>
        <div class="text-muted">
          {{ villager.profession }} — Уровень {{ villager.tradeLevel }}
        </div>
      </b-col>
      <b-col>
        <b-icon
          icon="person-fill"
          :style="{
            color: villagerColor,
          }"
          font-scale="1.2"
        />
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { stringToColor } from "../utils/design";

export default {
  props: {
    villager: {
      type: Object,
      required: true,
    },
  },
  computed: {
    villagerColor() {
      return stringToColor(this.villager.name + " id: " + this.villager.id);
    },
  },
};
</script>
