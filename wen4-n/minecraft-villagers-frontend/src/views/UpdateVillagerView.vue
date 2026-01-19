<template>
  <div class="page-wrapper">
    <b-card header="Редактирование жителя" class="big-card shadow">
      <villager-form
        v-if="villager !== null"
        :initialVillager="villager"
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
import { getVillagerById, updateVillager } from "../api/villagers";
import VillagerForm from "../components/VillagerForm.vue";

export default {
  props: ["villageId", "id"],
  data() {
    return {
      villager: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadItem();
  },
  methods: {
    async loadItem() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getVillagerById(this.id);
        this.villager = {
          id: res.data.id,
          name: res.data.name,
          tradeLevel: res.data.tradeLevel,
          profession: res.data.profession,
          villageId: this.villageId,
        };
      } catch (e) {
        this.error = `Failed to load villager with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    onCancel() {
      this.$router.push(`/villages/${this.villageId}`);
    },
    async onSave(villager) {
      await updateVillager(villager);
      this.$router.push(`/villages/${this.villageId}`);
    },
  },
  components: {
    VillagerForm,
  },
};
</script>
