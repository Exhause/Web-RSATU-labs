<template>
  <div class="page-wrapper">
    <b-card header="Создание новой деревни" class="big-card shadow">
      <village-form
        :initialVillage="{ id: 0, name: '' }"
        :onCancel="onCancel"
        :onSave="onSave"
      />
    </b-card>
  </div>
</template>
<script>
import { createVillage } from "../api/villages";
import VillageForm from "../components/VillageForm.vue";

export default {
  methods: {
    onCancel() {
      this.$router.push("/villages");
    },
    async onSave(village) {
      await createVillage(village);
      this.$router.push("/villages");
    },
  },
  components: {
    VillageForm,
  },
};
</script>
