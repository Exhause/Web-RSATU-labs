<template>
  <b-container fluid class="p-0">
    <b-row class="align-items-center">
      <b-col cols="11">
        <strong>{{ village.name }}</strong>
      </b-col>
      <b-col>
        <b-icon
          icon="house-fill"
          :style="{
            color: villageColor,
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
    village: {
      type: Object,
      required: true,
    },
  },
  computed: {
    villageColor() {
      return stringToColor(this.village.name + " id: " + this.village.id);
    },
  },
};
</script>
