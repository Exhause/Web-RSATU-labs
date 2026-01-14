<template>
  <router-link
    :to="{ name: 'village', params: { id: village.id } }"
    class="text-decoration-none"
  >
    <b-list-group-item class="d-flex align-items-center" button>
      <b-container fluid>
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
    </b-list-group-item>
  </router-link>
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
