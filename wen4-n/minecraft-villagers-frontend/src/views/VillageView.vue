<template>
  <div class="page-wrapper">
    <b-card
      :header="village && `Деревня ${village.name}`"
      class="big-card shadow"
    >
      <b-list-group v-if="village !== null">
        <template v-for="villager in village.villagers">
          <villager-list-item :key="villager.id" :villager="villager" />
        </template>
      </b-list-group>
      <template v-if="loading">
        <p>Loading...</p>
      </template>
      <template v-if="error !== null">
        <p>Error! {{ error }}</p>
      </template>
    </b-card>
  </div>
</template>

<script>
import { getVillageById } from "../api/villages";
import VillagerListItem from "../components/VillagerListItem.vue";

export default {
  props: ["id"],
  data() {
    return {
      village: null,
      loading: false,
      error: null,
    };
  },
  mounted() {
    this.loadVillage();
  },
  methods: {
    async loadVillage() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getVillageById(this.id);
        this.village = res.data;
      } catch (e) {
        this.error = `Failed to load village with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
  },
  components: {
    VillagerListItem,
  },
};
</script>
