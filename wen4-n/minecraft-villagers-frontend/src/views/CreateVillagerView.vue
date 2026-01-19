<template>
  <div class="page-wrapper">
    <b-card header="Создание нового жителя" class="big-card shadow">
      <villager-form
        :initialVillager="{
          id: 0,
          name: '',
          tradeLevel: 1,
          profession: '',
          villageId: villageId,
        }"
        :onCancel="onCancel"
        :onSave="onSave"
      />
    </b-card>
  </div>
</template>
<script>
import { createVillager } from "../api/villagers";
import VillagerForm from "../components/VillagerForm.vue";

export default {
  props: ["villageId"],
  methods: {
    onCancel() {
      this.$router.push(`/villages/${this.villageId}`);
    },
    async onSave(villager) {
      await createVillager(villager);
      this.$router.push(`/villages/${this.villageId}`);
    },
  },
  components: {
    VillagerForm,
  },
};
</script>
