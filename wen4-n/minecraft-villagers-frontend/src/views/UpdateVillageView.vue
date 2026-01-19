<template>
  <div class="page-wrapper">
    <b-card header="Редактирование деревни" class="big-card shadow">
      <village-form
        v-if="village !== null"
        :initialVillage="village"
        :onCancel="onCancel"
        :onSave="onSave"
      />
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
import { getVillageById, updateVillage } from "../api/villages";
import VillageForm from "../components/VillageForm.vue";

export default {
  props: ["id"],
  data() {
    return {
      village: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadVillage();
  },
  methods: {
    async loadVillage() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getVillageById(this.id);
        this.village = { id: res.data.id, name: res.data.name };
      } catch (e) {
        this.error = `Failed to load village with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    onCancel() {
      this.$router.push("/villages");
    },
    async onSave(village) {
      await updateVillage(village);
      this.$router.push("/villages");
    },
  },
  components: {
    VillageForm,
  },
};
</script>
